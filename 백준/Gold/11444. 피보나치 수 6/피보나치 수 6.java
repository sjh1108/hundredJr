import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // static int N;
    static int M;
    static int K;
    
    static long[][] dp = {{1, 1}, {1, 0}};
    final static long p = 1000000007;


    public static void main(String[] args) throws IOException{
        long[][] A = {{1, 1}, {1, 0}};

        long N = Long.parseLong(br.readLine());

        System.out.println(pow(A, N - 1)[0][0]);
    }

    static long[][] pow(long[][] A, long exp){

        if(exp == 1|| exp == 0){
            return A;
        }

        long[][] ret = pow(A, exp / 2);

        ret = multiply(ret, ret);

        if(exp % 2 == 1L){
            ret = multiply(ret, dp);
        }

        return ret;
    }

    static long[][] multiply(long[][] o1, long[][] o2){
        long[][] ret = new long[2][2];

        ret[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % p;
		ret[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % p;
		ret[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % p;
		ret[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % p;


        return ret;
    }
}