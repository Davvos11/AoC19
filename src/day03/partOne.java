package day03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class partOne {
    URL url = partOne.class.getResource("input");
    File input = new File(url.getPath());
    BufferedReader br;
    {
        try {
            br = new BufferedReader(new FileReader(input));
            String wire1 = br.readLine();
            String wire2 = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
