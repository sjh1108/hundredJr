import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;
    
    static int[] arr;
    static int[] f;
    static boolean[] brr;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        String s = br.readLine();

        N = 0;

        int count = s.length();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(c == '_'){
                count += 5;
            } else if(c == ':'){
                count++;
            }
        }

        System.out.println(count);
    }
}