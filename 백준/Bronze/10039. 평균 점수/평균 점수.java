import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        N = 0;
        for(int i = 0; i < 5; i++){
            int k = Integer.parseInt(br.readLine()) / 5;
            if(k < 8) k = 8;
            N += k;
        }
        System.out.println(N);
    }
}