import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static long K;
    
    static int[][] dp;


    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());

        System.out.println(pow(A, B));
    }

    static long pow(long A, long B){
        if(B == 1){
            return A % K;
        }

        long tmp = pow(A, B / 2);

        if(B % 2 == 1){
            return (tmp * tmp % K) * A % K;
        }

        return tmp * tmp % K;
    }
}