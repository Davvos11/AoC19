package day02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class partOne {
    public static void main(String[] args) throws IOException {
        URL url = day02.partOne.class.getResource("input");
        File input = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(input));
        String seq = br.readLine();


    }
}
