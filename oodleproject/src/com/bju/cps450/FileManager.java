package com.bju.cps450;

import java.io.*;
import java.util.List;
import java.util.Vector;

/**
 * Created by carragher on 1/18/16.
 */

//class that handles the insanity that is Java Temp files.
    // note that because of this system all files will end with a CR. shouldnt matter
public class FileManager {

    public static String[] initArray;
    public static FileReader read;
    public static File file;
    // line num
    public static List<Integer>  iList = new Vector<>();
    //file name
    public static List<String> sList = new Vector<>();
    public static FileWriter fw;
    public static BufferedWriter write;











    public static void generateTemp() throws IOException {
        //make the files readers and jazz
        try {
             file = File.createTempFile("temp",".tmp");
            file.deleteOnExit();
            fw = new FileWriter(file);

        } catch (IOException e) {
            e.printStackTrace();
        }

        write = new BufferedWriter(fw);
        for (String filename : initArray){
            // open file
            //write to temp file
            //save line numbers for the extra credit
            // savefile name

            try {
                BufferedReader read = new BufferedReader(new FileReader(filename));

                String sCurrentLine;

                int lineInc = 0;
                while((sCurrentLine = read.readLine()) != null){
                    write.write(sCurrentLine + "\n");
                    lineInc = lineInc + 1;
                }


                //save file and line numbers
                iList.add(lineInc);
                sList.add(filename);


            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }







        }
        write.close();
        fw.close();
    }
    //temp files how


}
