/**
 * @author Henry Wilt
 * @version 1.0
 * Class: CS376, Hw2
 */

import java.net.*;
import java.io.*;

public class QuoteClient{
    public static void main(String[] args) {
        int num_quotes = -1; // -1 means random quote
        if (args.length > 0) {
            num_quotes = Integer.parseInt(args[0]);
        }

        try {
            /* make connection to server socket */
            Socket sock = new Socket ("127.0.0.1",6013);

            /* sends the number of quotes to be sent back */
            PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
            pout.println(num_quotes);

            /* receives the quotes from the server */
            InputStream in = sock.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));
            
            /* read the date from the socket */
            String line;
            while ( (line = bin.readLine()) != null)
                System.out.println(line);

            /* close the socket connection*/
            sock.close();
        }
        catch (IOException ioe){
            System.out.println(ioe);
        }
    }
}