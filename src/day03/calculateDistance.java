package day03;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
        System.out.println(p.setUp());
    }
}
