package com.ggl.esb.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class UTF8ToAnsiUtils {
    public static final String UTF8_BOM = "\uFEFF";

    public static void main(String args[]) {
        try {
//            if (args.length != 2) {
//                System.out.println("Usage : java UTF8ToAnsiUtils utf8file ansifile");
//                System.exit(1);
//            }

            boolean firstLine = true;
            FileInputStream fis = new FileInputStream("test/temp/input_data.txt");
            BufferedReader r = new BufferedReader(new InputStreamReader(fis, "UTF8"));
            FileOutputStream fos = new FileOutputStream("test/temp/output_data.txt");
            Writer w = new BufferedWriter(new OutputStreamWriter(fos, "UTF8"));
            for (String s = ""; (s = r.readLine()) != null;) {
                if (firstLine) {
                    s = UTF8ToAnsiUtils.removeUTF8BOM(s);
                    System.out.println(s);
                    firstLine = false;
                }
                w.write(s + System.getProperty("line.separator"));
                w.flush();
            }

            w.close();
            r.close();
            System.exit(0);
        }

        catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static String removeUTF8BOM(String s) {
    
        return s.replaceAll(UTF8_BOM, "");
    }
}
