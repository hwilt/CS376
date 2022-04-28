/**
 * @author Henry Wilt
 * Class: CS376, Hw4
 */

import java.io.*;
import java.util.*;

public class Main {

    /**
     * ReadInConfig reads in the configuration file
     * 
     * @param configFile String location of the configuration file
     * @return ArrayList<Int[]> of the configuration file
     */
    public static ArrayList<PCB> readInConfig(String configFile) {
        ArrayList<PCB> ret = new ArrayList<PCB>();
        try {
            FileReader fr = new FileReader(configFile);
            Scanner myReader = new Scanner(fr);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.length() > 0) {
                    String[] dataSplit = data.split(" ");
                    int PID = Integer.parseInt(dataSplit[0]);
                    int creationTime = Integer.parseInt(dataSplit[1]);
                    int burstTime = Integer.parseInt(dataSplit[2]);
                    PCB pcb = new PCB(PID, creationTime, burstTime);
                    ret.add(pcb);
                }
            }
            myReader.close();
        } catch (IOException e) {
            System.out.println("File Error: " + e);
        }
        return ret;
    }

    public static void main(String[] args) {
        String configFileName = "";
        if (args.length >= 1) {
            configFileName = args[0];
            // Read in the configuration file
            ArrayList<PCB> config = readInConfig(configFileName);
            // Create the scheduler
            /* print out the config
            for (PCB pcb : config) {
                System.out.println(pcb.toString());
            }*/
            Scheduler scheduler = new Scheduler(config);
            // Run the scheduler
            scheduler.run();
        }
        else{
            System.out.println("Please enter a configuration file name.\njava Main <Config file>");
        }
    }
}