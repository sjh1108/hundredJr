import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        int pisano = 1500000;
        Long N = Long.parseLong(br.readLine()) % pisano;
        
        long[] fibo = new long[pisano + 1];

        fibo[0] = 0; fibo[1] = 1;
        for (int i = 2; i <= pisano; i++) {
            fibo[i] = (fibo[i - 1] + fibo[i - 2]) % 1000000;
        }

        System.out.println(fibo[N.intValue()]);
    }
}