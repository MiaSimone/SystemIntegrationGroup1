package com.camunda;

import sun.misc.IOUtils;

import java.io.*;

public class ReadFromFile {


    public String ReadFromFile(int reply) throws IOException {


        File file = new File(
                "src/main/resources/files/file" + reply + ".txt");

        BufferedReader br = new BufferedReader(new FileReader(file));
        String everything = "";
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        } finally {
            br.close();
        }
        return everything;
    }

}
