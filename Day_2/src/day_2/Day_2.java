package day_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Day_2 {
    private static final String FILENAME = "/Users/adamnguyen/Documents/Github/"
            + "Advent of Code 2016/Day_2/src/day_2/input";

    public static void main(String[] args) {
        ArrayList<String> code = read_input();
        Previous_Number prev = new Previous_Number();

        for(int i = 0; i < code.size(); i++) {
            System.out.println(move_on_keypad(code.get(i), prev) + ", ");
        }
    }

    public static int move_on_keypad(String key_line, Previous_Number prev) {
        int x = 0, y = 0;
        final int[][] keypad = new int[][]{
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        
        // Loop through each char in key_line
        for (int i = 0; i < key_line.length(); i++)
        {
            char c = key_line.charAt(i);
            // Get index of previous number
            // Should probably move to another method
            loop:
            for (int a = 0; a < keypad.length; a++) {
                for (int b = 0; b < keypad.length; b++) {
                    if (keypad[a][b] == prev.get()) {
                        x = a;
                        y = b;
                        break loop;
                    }
                }
            }

            /*
            Up:    [-1][0]
            Down:  [+1][0]
            Left:  [0][-1]
            Right: [0][+1]
            */
            if (x < 2 || y < 2)
                continue;
            else{
                switch(c) {
                    case 'U':
                        x--;
                        break;
                    case 'D':
                        x++;
                        break;
                    case 'L':
                        y--;
                        break;
                    case 'R':
                        y++;
                        break;
                }
            }  
            prev.set(keypad[x][y]); 
        }
        return prev.get();
    }

    public static ArrayList<String> read_input() {
        BufferedReader br = null;
        FileReader fr = null;
        ArrayList<String> output = new ArrayList<String>();

        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);
            String sCurrentLine;
            br = new BufferedReader(new FileReader(FILENAME));

            while ((sCurrentLine = br.readLine()) != null) {
                output.add(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return output;
    }
}
