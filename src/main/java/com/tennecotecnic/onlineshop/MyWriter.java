package com.tennecotecnic.onlineshop;
import java.io.*;

public class MyWriter {
    public static void writeInfo (String text, String fileName) {
        try (FileWriter writer = new FileWriter(fileName, true)) {
           String textsum = text+"\r\n";
            writer.write(textsum);
            writer.flush();
            writer.close();
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
