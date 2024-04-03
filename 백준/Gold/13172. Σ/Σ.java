import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static final int mod = 1000000007;

    public static void main(String[] args) throws IOException{
        M = Integer.parseInt(br.readLine());
        long N = 1, S = 0;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            S = s * N + S * n;
            N *= n;

            S %= mod;
            N %= mod;
        }

        if(S % N != 0)
            System.out.println(gcd(N, mod-2) * S % mod);
        else
            System.out.println(S / N);
    }
    
    static long gcd(long N, int idx){
        if(idx == 1)
            return N;
        long tmp = gcd(N, idx / 2);
        if(idx % 2 == 0)
            return tmp * tmp % mod;
        else
            return tmp * tmp % mod * N % mod;
    }
}