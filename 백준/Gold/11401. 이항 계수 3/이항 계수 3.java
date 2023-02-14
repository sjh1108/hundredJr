import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static long N;
    static int M;
    static long K;
    
    static int[][] dp;
    final static int p = 1000000007;


    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());

        long numer = factorial(N);

        long denom = factorial(K) * factorial(N - K) % p;

        System.out.println(numer * pow(denom, p - 2) % p);
    }

    static long factorial(long N){
        long fac = 1L;

        while(N > 1){
            fac = (fac * N) % p;
            N--;
        }

        return fac;
    }

    static long pow(long base, long expo){
        if(expo == 1){
            return base % p;
        }

        long temp = pow(base, expo / 2);

        if(expo % 2 == 1){
            return (temp * temp % p) * base % p;
        }

        return temp * temp % p;
    }
}