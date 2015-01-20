package models;

import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import play.data.validation.Constraints.*;

public class HadoopInfo {

  @Required
  public String info;

  public static void submit(HadoopInfo info) {

     String command = "hadoop jar wordcount.jar com.hadoop.WordCount /user/hduser/gutenberg /user/hduser/gutenberg-out-2";

     String output = executeCommand(command);

     getResultToPlay();

  }

  public static void getResultToPlay() {
     String command = "/usr/local/hadoop/bin/hadoop fs -get /user/hduser/gutenberg-out-2/part-r-00000 /home/hduser/activator-1.2.12/playhelloworld/";

     String output = executeCommand(command);
  }


  private static String executeCommand(String command) {

    StringBuffer output = new StringBuffer();

    Process p;
    try {
        p = Runtime.getRuntime().exec(command);
        p.waitFor();
        BufferedReader reader =
                   new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line = "";
        while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return output.toString();

    }

  public String getInfo() {
      return this.info;
  }
}
