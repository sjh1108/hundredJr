import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int max;
    
    static int[] arr;
    static int[] srr;

    static long[] f;
    static long[] lrr;

    static int[][] dp;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[N + 1][N + 1];

        for(int i = 1; i < N + 1; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N + 1; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] += dp[i][j - 1];
            }
        }

        long sum = 0;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            sum = 0;

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            int xgap = c - a;
            
            for(int j = a; j <= xgap + a; j++){
                sum += func(j, b, d);
            }

            sb.append(sum);
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static int func(int x, int i, int j){
        return dp[x][j] - dp[x][i - 1];
    }

}