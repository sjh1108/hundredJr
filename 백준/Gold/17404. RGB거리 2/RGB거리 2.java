import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, K;
    
    static final int MAX = 1000 * 1000 + 1;
    static int[][] dp;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N+1][3];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        int result = MAX;

        dp = new int[N+1][3];
        for(int rgb = 0; rgb < 3; rgb++){

            dp[1][rgb] = arr[1][rgb];
            dp[1][(rgb+1) % 3] = MAX;
            dp[1][(rgb+2) % 3] = MAX;

            for(int i = 2; i < N+1; i++){
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
            }

            for(int i = 0; i < 3; i++){
                if(i == rgb) continue;

                result = Math.min(result, dp[N][i]);
            }
        }

        System.out.println(result);
    }
}