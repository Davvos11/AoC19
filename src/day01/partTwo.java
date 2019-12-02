package day01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class partTwo {
    public static void main(String[] args) throws IOException {
        partTwo p = new partTwo();

        URL url = partOne.class.getResource("input");
        File input = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(input));
        String line;

        int fuelSum = 0;

        while ((line = br.readLine()) != null){
            int mass = Integer.parseInt(line);
            int fuel = p.fuelRequired(mass);

            fuelSum += fuel;
        }

        System.out.println(fuelSum);
    }

    private int fuelRequired(int mass){
        int required = Math.floorDiv(mass,3)-2;
        if (required > 0){
            return required+fuelRequired(required);
        }
        else {
            return 0;
        }
    }
}
