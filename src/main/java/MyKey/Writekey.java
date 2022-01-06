package MyKey;

import java.io.FileWriter;
import java.io.IOException;

public class Writekey {

        public static void main(String[] args) {
            String key = args[0];
            try {
                FileWriter myWriter = new FileWriter("C:/Yahoo_Finance/Report/Key.maxk");
                myWriter.write(key);
                myWriter.close();
             ////   System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
            ////    System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

