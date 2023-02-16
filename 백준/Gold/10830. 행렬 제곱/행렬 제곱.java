import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;
    
    static int[][] dp;
    final static int p = 1000;


    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        dp = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                dp[i][j] = Integer.parseInt(st.nextToken()) % p;
            }
        }

        int[][] result = pow(dp, B);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(result[i][j]).append(' ');
            }
            sb.append('\n');
        }
        
        System.out.println(sb);
    }

    static int[][] pow(int[][] A, long exp){
        if(exp == 1L){
            return A;
        }

        int[][] ret = pow(A, exp / 2);

        ret = multiply(ret, ret);

        if(exp % 2 == 1L){
            ret = multiply(ret, dp);
        }

        return ret;
    }

    static int[][] multiply(int[][] o1, int[][] o2){
        int[][] ret = new int[N][N];

        int r;
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                r = o1[i][k];			
                for (int j = 0; j < N; j++) {
                    ret[i][j] += r * o2[k][j];
                    ret[i][j] %= p;
                }
            }
        }

        return ret;
    }
}