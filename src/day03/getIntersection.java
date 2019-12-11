package day03;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class getIntersection {
    private ArrayList<String[]> setUp(){
        URL url = getIntersection.class.getResource("input");
        File input = new File(url.getPath());
        BufferedReader br;
        String wire1 = null; String wire2 = null;
        try {
            br = new BufferedReader(new FileReader(input));
            wire1 = br.readLine();
            wire2 = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] wire1Path = wire1.split(",");
        String[] wire2Path = wire2.split(",");

        ArrayList<String[]> result = new ArrayList<String[]>();
        result.add(wire1Path); result.add(wire2Path);

        return result;
    }

    private int x = 0;
    private int y = 0;
    private List<Integer> steps = new ArrayList<>();
    private int step = -1;

    private void addStep(List<List<Integer>> XYs, List<List<Integer>> wireXY){
        if (wireXY.size() < 1 || XYs.size() < 1){
            step++;
        }
        else if (!XYs.get(XYs.size()-1).equals( wireXY.get(wireXY.size()-1) )){
            step++;
        }
        steps.add(step);
    }

    private List<List<Integer>> parseWire(String a, List<List<Integer>> wireXY){
        String dir = a.substring(0,1);
        int len = Integer.parseInt(a.substring(1));

        List<List<Integer>> XYs = new ArrayList<>();

        switch (dir){
            case "R":
                for (int i = 0; i <= len; i++) {
                    XYs.add(newXY(x+i,y));
                    addStep(XYs, wireXY);
                }
                x+=len;
                break;
            case "L":
                for (int i = 0; i <= len; i++) {
                    XYs.add(newXY(x-i,y));
                    addStep(XYs, wireXY);
                }
                x-=len;
                break;
            case "U":
                for (int i = 0; i <= len; i++) {
                    XYs.add(newXY(x,y+i));
                    addStep(XYs, wireXY);
                }
                y+=len;
                break;
            case "D":
                for (int i = 0; i <= len; i++) {
                    XYs.add(newXY(x,y-i));
                    addStep(XYs, wireXY);
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
            wire1XY.addAll(p.parseWire(a,wire1XY));
        }

        List<Integer> steps1 = p.steps;
        p.x = 0;
        p.y = 0;
        p.step = -1;
        p.steps = new ArrayList<>();

        List<List<Integer>> wire2XY = new ArrayList<>();
        for (String a : wire2){
            wire2XY.addAll(p.parseWire(a,wire2XY));
        }

        List<Integer> steps2 = p.steps;

//        System.out.println(wire1XY);
//        System.out.println(steps1);
        System.out.println("Parsed wires, comparing paths...");

        List<List<Integer>> intersects = new ArrayList<>();
        for (List<Integer> xy : wire1XY) {
            if (wire2XY.contains(xy)){
                List<Integer> res = new ArrayList<>();
                res.add(xy.get(0));
                res.add(xy.get(1));
                res.add(steps1.get( wire1XY.indexOf(xy) ));
                res.add(steps2.get( wire2XY.indexOf(xy) ));

                intersects.add(res);
            }
        }

        System.out.println(intersects);
        try {
            FileOutputStream fileOut = new FileOutputStream("src/day03/intersects.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(intersects);
            objectOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
