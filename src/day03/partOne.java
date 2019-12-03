package day03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class partOne {
    private ArrayList<String[]> setUp(){
        URL url = partOne.class.getResource("input");
        File input = new File(url.getPath());
        BufferedReader br;
        String wire1 = null; String wire2 = null;
        {
            try {
                br = new BufferedReader(new FileReader(input));
                wire1 = br.readLine();
                wire2 = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String[] wire1Path = wire1.split(",");
        String[] wire2Path = wire2.split(",");

        ArrayList<String[]> result = new ArrayList<String[]>();
        result.add(wire1Path); result.add(wire2Path);

        return result;
    }

    public static void main(String[] args) {
        partOne p = new partOne();
        ArrayList<String[]> wires = p.setUp();
        String[] wire1 = wires.get(0);
        String[] wire2 = wires.get(1);

        List<Integer> x;
        List<Integer> y;

        for (int i = 0; i < wire1.length; i++) {

        }
    }



}
