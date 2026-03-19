import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        // if(N == 64){
        //     System.out.println(1);
        //     return;
        // }
        int len = 64;
        int count = 0;

        while(len > 0){
            if(len <= N){
                N -= len;
                count++;
            }
            if(N == 0) break;

            len /= 2;
        }

        System.out.println(count);
    }

}