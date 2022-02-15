/**
 * @author Henry Wilt
 * @version 1.0
 * Class: CS376, Hw2
 */

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class QuoteServer {

    // The number of quotes in the file
    private static final int NUM_OF_QUOTES = 99;


    /**
     * getQuotes
     * Reads the quotes from the file and returns them as a string array
     * 
     * @return String[] all the quotes from the file 
     */
    public static String[] getQuotes(){
        String[] res = new String[NUM_OF_QUOTES];
        try{
            File file = new File("quotes.txt");
            Scanner myReader = new Scanner(file);
            int i = 0;
            while(myReader.hasNextLine()){
                res[i] = myReader.nextLine();
                i++;
            }
            myReader.close();
        } catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        return res;
    }


    public static void main(String[] args) {
        try {
            ServerSocket sock = new ServerSocket (6013);
            String[] quotes = getQuotes();
            /* now listen for connections */
            while (true) {
                Socket client = sock.accept();
                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
                
                /* Checks for the number of quotes to be sent */
                InputStream in = client.getInputStream();
                BufferedReader bin = new BufferedReader(new InputStreamReader(in));
                String line;
                if ((line = bin.readLine()) != null) {
                    int num_quotes = Integer.parseInt(line);
                    /* If the number of quotes is -1 then the client is requesting a random quote */
                    if (num_quotes == -1) {
                        // Generate a random number between 0 and the total number of quotes
                        int random = (int)(Math.random() * quotes.length);
                        pout.println(quotes[random]);
                    }
                    else {
                        for (int i = 0; i < num_quotes; i++) {
                            // Generate a random number between 0 and the total number of quotes
                            int random = (int)(Math.random() * quotes.length);
                            pout.println(quotes[random]); // sends the quotes back to the client
                        }
                    }
                }
                /* close the socket and resume */
                /* listening for connections */
                client.close();
            }
        }
        catch (IOException ioe) {
            System.err.println(ioe);
        }
    }
}