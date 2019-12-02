package day02;

import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URL;

public class partOne {
    private enum State {
        OPCODE, DO
    }
    private enum Action {
        ADD, MULTIPLY
    }

    public static void main(String[] args) throws IOException {
        URL url = partOne.class.getResource("input");
        File input = new File(url.getPath());
        BufferedReader br = new BufferedReader(new FileReader(input));
        String seq = br.readLine();
        br.close();

        String[] seqsString = seq.split(",");
        int[] seqs = new int[seqsString.length+3];
        int j = 0;
        for (String sString : seqsString) {
            seqs[j] = Integer.parseInt(sString);
            j++;
        }

        seqs[1]=12;
        seqs[2]=2;

        State state = State.OPCODE;
        Action action = null;

        for (int i = 0; i < seqs.length; i++) {
            switch (state){
                case OPCODE:
                    System.out.print("["+i+"]");
                    switch (seqs[i]) {
                        case 99:
                            System.out.print("Opcode 99: exit ");
                            i = seqs.length;
                            break;
                        case 1:
                            System.out.print("Opcode 1: add ");
                            action = Action.ADD;
                            state = State.DO;
                            break;
                        case 2:
                            System.out.print("Opcode 2: multiply ");
                            action = Action.MULTIPLY;
                            state = State.DO;
                            break;
                        default:
                            System.out.print("Opcode " + seqs[i] + ": ERROR");
                            break;
                    }
                    break;
                case DO:
                    int in1 = seqs[i];
                    int in1Val = seqs[in1];
                    int in2 = seqs[i+1];
                    int in2Val = seqs[in2];
                    int out = seqs[i+2];
                    System.out.println(in1+"="+in1Val+" and "+in2+"="+in2Val+", store in "+out);
                    switch (action){
                        case ADD:
                            seqs[out] = in1Val+in2Val;
                            break;
                        case MULTIPLY:
                            seqs[out] = in1Val*in2Val;
                            break;
                    }
                    i+=2; // Add 2 extra, so i+=3
                    state = State.OPCODE;
                    break;
            }
            
        }

        System.out.println("\n\n"+seqs[0]);

        BufferedWriter bw = new BufferedWriter(new FileWriter("src/day02/output"));
        Boolean fst = true;
        for (int s : seqs) {
            if (!fst){
                bw.append(",");
            }
            fst = false;
            bw.append(String.valueOf(s));
        }
        bw.close();
    }
}
