package day03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class getIntersection {
    private ArrayList<String[]> setUp(){
        URL url = getIntersection.class.getResource("input");
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

    private int x = 0;
    private int y = 0;

    private List<List<Integer>> parseWire(String a){
        String dir = a.substring(0,1);
        int len = Integer.parseInt(a.substring(1));

        List<List<Integer>> XYs = new ArrayList<>();

        switch (dir){
            case "R":
                for (int i = 0; i <= len; i++) {
                    XYs.add(newXY(x+i,y));
                }
                x+=len;
                break;
            case "L":
                for (int i = 0; i <= len; i++) {
                    XYs.add(newXY(x-i,y));
                }
                x-=len;
                break;
            case "U":
                for (int i = 0; i <= len; i++) {
                    XYs.add(newXY(x,y+i));
                }
                y+=len;
                break;
            case "D":
                for (int i = 0; i <= len; i++) {
                    XYs.add(newXY(x,y-i));
                }
                y-=len;
                break;
        }
        return XYs;
    }

    private List<Integer> newXY(int x, int y){
        List<Integer> XY = new ArrayList<>();
        XY.add(x);
        XY.add(y);
        return XY;
    }

    public static void main(String[] args) {
        getIntersection p = new getIntersection();
        ArrayList<String[]> wires = p.setUp();
        String[] wire1 = wires.get(0);
        String[] wire2 = wires.get(1);

        List<List<Integer>> wire1XY = new ArrayList<>();
        for (String a : wire1){
            wire1XY.addAll(p.parseWire(a));
        }
        p.x = 0;
        p.y = 0;
        List<List<Integer>> wire2XY = new ArrayList<>();
        for (String a : wire2){
            wire2XY.addAll(p.parseWire(a));
        }

        System.out.println("Parsed wires, comparing paths...");

        List<List<Integer>> intersects = new ArrayList<>(wire1XY);
        intersects.retainAll(wire2XY);

        System.out.println(intersects);
        try {
            FileWriter fw = new FileWriter("src/day03/intersects.txt");
            fw.write(intersects.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
