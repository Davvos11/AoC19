package day01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class partOne {
    public static void main(String[] args) throws IOException {
        URL url = partOne.class.getResource("input");
        File input = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line;

        int fuelSum = 0;

        while ((line = br.readLine()) != null){
            int mass = Integer.parseInt(line);
            int fuel = Math.floorDiv(mass,3)-2;

            fuelSum += fuel;
        }

        System.out.println(fuelSum);
    }
}
