package day02;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class partTwo {
    private partOne p = new partOne();

    public int nounVerb(int noun, int verb) {
        URL url = partOne.class.getResource("input");
        File input = new File(url.getPath());
        int[] seqs = p.initMemory(input);

        seqs[1]=noun;
        seqs[2]=verb;

        p.computer(seqs);

        return seqs[0];
    }

    public static void main(String[] args) {
        partTwo q = new partTwo();

        int noun = 0;
        int verb = 0;
        while (verb <= 99 && q.nounVerb(noun,verb) != 19690720){
            if (noun < 99){
                noun++;
            }
            else{
                noun = 0;
                verb++;
            }
        }
        if (verb == 99){
            System.out.println("Not found");
        }
        else {
            System.out.println(noun+","+verb/**/);
        }
    }
}
