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
        
        
    }
}