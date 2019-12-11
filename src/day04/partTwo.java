package day04;

import java.util.ArrayList;
import java.util.List;

public class partTwo {
    public static void main(String[] args) {
        String input = "273025-767253";
        int low  = Integer.parseInt(input.split("-")[0]);
        int high = Integer.parseInt(input.split("-")[1]);

        List<Integer> possiblePasswords = new ArrayList<>();

        for (int i = low; i <= high; i++) {
            // Add digits to array:
            List<Integer> digits= new ArrayList<>();
            for (int d = 5; d >= 0; d--) {
                int digit = (int) (( i % Math.pow(10,d+1) ) / Math.pow(10,d));
                digits.add(digit);
            }

            // Check decreasing and adjacent
            boolean decreasing = false;
            boolean adjacent = false;

            for (int j = 0; j < digits.size()-1; j++) {
                if (digits.get(j) > digits.get(j + 1)) {
                    decreasing = true;
                    break;
                }
                if (digits.get(j).equals(digits.get(j + 1))){
                    adjacent = true;
                    if (j+2 != digits.size() && digits.get(j+1).equals(digits.get(j+2))) {
                        adjacent = false;
                        break;
                    }
                }
            }
            if (!decreasing && adjacent){
                possiblePasswords.add(i);
            }
        }
        System.out.println(possiblePasswords);
        System.out.println(possiblePasswords.size());
    }
}
