import java.net.*;
import java.io.*;
import java.util.Scanner;

public class QuoteServer {

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
                    if (num_quotes == -1) {
                        int random = (int)(Math.random() * quotes.length);
                        pout.println(quotes[random]);
                    }
                    else {
                        for (int i = 0; i < num_quotes; i++) {
                            int random = (int)(Math.random() * quotes.length);
                            pout.println(quotes[random]);
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