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
     * @return ArrayList<String> of the configuration file
     */
    public static ArrayList<int[]> readInConfig(String configFile) {
        ArrayList<int[]> ret = new ArrayList<int[]>();
        try {
            FileReader fr = new FileReader(configFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int[] dataArray = String.parseInt(data.split(" "));
                ret.add(dataArray);
            }
            myReader.close();
        } catch (IOException e) {
            System.out.println("File Error: " + e);
        }
        return ret;
    }

    public static void main(String[] args) {
        String configLocation = "config.txt";
        ArrayList<int[]> config = readInConfig(configLocation);
        for (int[] data : config) {
            for (int i : data) {
                System.out.print(i);
            }
            System.out.println();
        }
    }
}