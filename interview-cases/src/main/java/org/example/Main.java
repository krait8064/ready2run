package org.example;

import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static final String SEP = ";";
    public static void main(String[] args) {
        extractOfferRequirements(args);
    }

    /**
     * extract from excel recorded data
     * @param args args[0] readfile path in ../../resources/skills.csv,write file path in ../../resources/keys.txt
     */
    private static void extractOfferRequirements(String[] args) {
        String readPath = args[0];
        String writePath = args[1];
        System.out.println (readPath);
        System.out.println (writePath);
        File writeFile = new File(writePath);
        if(!writeFile.exists()){
            try {
                if (!writeFile.createNewFile()){
                    System.out.println ("create write file failed");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            try {
                new FileWriter(writeFile, false).close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (BufferedReader br = new BufferedReader(new FileReader(readPath));BufferedWriter bw = new BufferedWriter(new FileWriter(writePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                line = line.toLowerCase();
                if (!line.isEmpty()) {
                    String[] keys = line.split(SEP);
                    for (String key : keys) {
                        String formatKey = key.trim().toLowerCase();
                        if (!formatKey.isEmpty()) {                        bw.write(formatKey);
                            bw.newLine();}
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}