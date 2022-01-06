package MyKey;

import Form.Form;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadKey {


    public static void main(String[] args) {
        try {
            File myObj = new File("C:/Yahoo_Finance/Report/Key.maxk");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
            ////    System.out.println("Data "+data);
                // send oldkey to textbox1 first step
                String args2 = new String(data);
              Form.getsaveddata(args2);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }



    }








