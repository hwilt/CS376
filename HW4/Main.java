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
                String[] dataArray = data.split(" ");
                int[] dataInt = new int[dataArray.length];
                ret.add(new PCB(Integer.parseInt(dataArray[0]), Integer.parseInt(dataArray[1]), Integer.parseInt(dataArray[2])));
            }
            myReader.close();
        } catch (IOException e) {
            System.out.println("File Error: " + e);
        }
        return ret;
    }

    public static void main(String[] args) {
        // Read in the configuration file
        ArrayList<PCB> config = readInConfig("config.txt");
        // Create the scheduler
        Scheduler scheduler = new Scheduler(config);
        // Run the scheduler
        scheduler.run();
    }
}