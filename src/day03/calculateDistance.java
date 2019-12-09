package day03;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class calculateDistance {
    private List<List<Integer>> setUp(){
        try {
            FileInputStream fileIn = new FileInputStream("src/day03/intersects.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            objectIn.close();
            return (List<List<Integer>>) obj;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        calculateDistance p = new calculateDistance();
        List<List<Integer>> intersects = p.setUp();

        intersects.remove(0);

        int closest = -1;
        for (List<Integer> i : intersects){
            int distance = Math.abs(i.get(0)) + Math.abs(i.get(1));
            if (distance < closest || closest == -1){
                closest = distance;
            }
        }

        System.out.println(closest);
    }
}
