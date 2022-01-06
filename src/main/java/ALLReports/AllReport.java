package ALLReports;


import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;


public class AllReport {
    private static FileWriter file;
    

    
    
    public static void main(String[] args) throws UnirestException {

       
       
       String Profilecurrent =ProfileContoller.profilename;
        System.out.println("test Profilecurrent =  "+Profilecurrent);
      if(Profilecurrent==null){
          Profilecurrent="Profile1";
      }
        
       // System.out.println("from runall" + Arrays.toString(args));

        List<String> applist = Arrays.asList(args);
        applist.forEach(Apps -> System.out.println(Apps));


        String textApps = "";
        String savetextapps="";
        for (int i = 0; i < applist.size(); i++) {
            if (i == 0) {
                textApps = "@echo off \nping 1.1.1.1 -n 1 -w 1000 > nul \n" + "start \"Application" + i + "\" \"" + applist.get(i) + "\"";
                savetextapps=applist.get(i);
            } else {
                textApps=textApps+"\n" + "start \"Application" + i + "\" \"" + applist.get(i) + "\"";
                savetextapps=savetextapps+"\n"+applist.get(i);
            }

        }
       // Create Directory

        try {
            Path path = Paths.get("user.dir/Click");
          //  deleteDirectory(new File(path.toString()));
            Files.createDirectories(path);
        } catch (IOException e) {
            System.err.println("Failed to create directory!" + e.getMessage());
        }

// Constructs a FileWriter given a file name, using the platform's default charset
        try {

            file = new FileWriter("user.dir/Click/"+Profilecurrent +"morning.bat",StandardCharsets.UTF_8);
            file.write(textApps);
        } catch (
                IOException e) {
            e.printStackTrace();

        } finally {
            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
 ////////////////////////////////////// // Create Save FIle    ////////////////////////////////////////////////////////////////////////////////////////////// 
   try {

            file = new FileWriter("user.dir/Click/"  +Profilecurrent + "morning.txt", StandardCharsets.UTF_8);
            file.write(savetextapps);
        } catch (
                IOException e) {
            e.printStackTrace();

        } finally {
            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }   
   
   JOptionPane.showMessageDialog(null, "You Create/Update your profile \r\n Now You Can Run That Avery Morning.");

    }

    static public void CrunchifyLog(String str) {

    }


    public static boolean deleteDirectory(File dir) {
        if (dir.isDirectory()) {
            File[] children = dir.listFiles();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDirectory(children[i]);
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }


    
    
}



