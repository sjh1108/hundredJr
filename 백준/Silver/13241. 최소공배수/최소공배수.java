import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        bw.write(a * b / ((a > b) ? gcd(a, b) : gcd(b, a)) + "\n");
        bw.flush();
        // System.out.println(a * b / ((a > b) ? gcd(a, b) : gcd(b, a)));
    }

    static long gcd(long a, long b){
        while(b > 0){
            long tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}