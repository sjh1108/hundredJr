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

        int a = 1, b = 0;

        for(int i = 0; i < N; i++){
            int na = b;
            int nb = a + b;

            a = na; b = nb;
        }

        System.out.println(a + " " + b);
    }
}