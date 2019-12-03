package day02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

public class partOne {
    private enum State {
        OPCODE, DO
    }
    private enum Action {
        ADD, MULTIPLY
    }

    public int[] initMemory(File input)  {
        String seq = "";
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(input));
            seq = br.readLine();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] seqsString = seq.split(",");
        int[] seqs = new int[seqsString.length+3];
        int j = 0;
        for (String sString : seqsString) {
            seqs[j] = Integer.parseInt(sString);
            j++;
        }

        return seqs;
    }

    public void computer(int[] seqs){
        computer(seqs, false);
    }

    public void computer(int[] seqs, Boolean print){
        State state = State.OPCODE;
        Action action = null;

        for (int i = 0; i < seqs.length; i++) {
            switch (state){
                case OPCODE:
                    if (print) { System.out.print("["+i+"]");}
                    switch (seqs[i]) {
                        case 99:
                            if (print) { System.out.print("Opcode 99: exit\n");}
                            i = seqs.length;
                            break;
                        case 1:
                            if (print) { System.out.print("Opcode 1: add ");}
                            action = Action.ADD;
                            state = State.DO;
                            break;
                        case 2:
                            if (print) { System.out.print("Opcode 2: multiply ");}
                            action = Action.MULTIPLY;
                            state = State.DO;
                            break;
                        default:
                            if (print) { System.out.print("Opcode " + seqs[i] + ": ERROR");}
                            break;
                    }
                    break;
                case DO:
                    int in1 = seqs[i];
                    int in1Val = seqs[in1];
                    int in2 = seqs[i+1];
                    int in2Val = seqs[in2];
                    int out = seqs[i+2];
                    if (print) { System.out.println(in1+"="+in1Val+" and "+in2+"="+in2Val+", store in "+out);}
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
    }

    public static void main(String[] args) {
        partOne p = new partOne();

        URL url = partOne.class.getResource("input");
        File input = new File(url.getPath());
        int[] seqs = p.initMemory(input);

        seqs[1]=12;
        seqs[2]=2;

        p.computer(seqs);

        System.out.println("\n\n"+seqs[0]);
    }
}
