package MyKey;

import java.io.File;
import java.io.IOException;

public class KeyRecorder {

    // File create ///////////////////
    public static void main(String[] args) {

        try {
            File myObj = new File("C:/Yahoo_Finance/Report/Key.maxk");
            if (myObj.createNewFile()) {
               System.out.println("File created: " + myObj.getName());
            } else {
               System.out.println("File already exists.");
            }
        } catch (IOException e) {
           System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}

