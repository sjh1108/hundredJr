import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException{
        String s;
        
        while ((s = br.readLine()) != null) {
            int small = 0;
            int capital = 0;
            int number = 0;
            int space = 0;
            
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ' ') space++;
                if (Character.isUpperCase(c)) capital++;
                if (Character.isLowerCase(c)) small++;
                if (Character.isDigit(c)) number++;
            }
            sb.append(small + " " + capital + " " + number + " " + space + "\n");
        }
        System.out.print(sb);
    }
}