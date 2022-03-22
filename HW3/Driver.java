/**
 * @author Henry Wilt
 * Class: CS376, Hw3
 */

import java.io.*;
import java.util.*;

public class Driver {

    /**
     * ReadInConfig reads in the configuration file
     * 
     * @param configFile String location of the configuration file
     * @return ArrayList<Int[]> of the configuration file
     */
    public static ArrayList<int[]> readInConfig(String configFile) {
        ArrayList<int[]> ret = new ArrayList<int[]>();
        try {
            FileReader fr = new FileReader(configFile);
            Scanner myReader = new Scanner(fr);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] dataArray = data.split(" ");
                int[] dataInt = new int[dataArray.length];
                for (int i = 0; i < dataArray.length; i++) {
                    dataInt[i] = Integer.parseInt(dataArray[i]);
                }
                ret.add(dataInt);
            }
            myReader.close();
        } catch (IOException e) {
            System.out.println("File Error: " + e);
        }
        return ret;
    }

    public static void main(String[] args) {
        String configFileName = "";
        String typeOfSchedule = ""; 
        int timeQuantum;
        // Command Line Arguments
        if (args.length >= 2) {
            configFileName = args[0];
            typeOfSchedule = args[1];
            ArrayList<int[]> config = readInConfig(configFileName);
            CPU cpu = new CPU(config);
            if (typeOfSchedule.equals("RR") && args.length == 3) {
                timeQuantum = Integer.parseInt(args[2]);
                cpu.setQuantumTime(timeQuantum);
                cpu.roundRobin();
            } 
            else if (typeOfSchedule.equals("FCFS")) {
                cpu.firstComeFirstServe();
            } 
            else if (typeOfSchedule.equals("SJF")) {
                cpu.shortestJobFirst();
            }
        }
        else{
            System.out.println("Usage: java Driver <config file> <RR> <TimeQuantum>");
        }
        
    }
}