import java.io.*;
import java.util.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int N, M, K;

    static int[][] dp;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] memory = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            memory[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        int[] cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
            sum += cost[i];
        }

        dp = new int[N][sum+1];
        K = sum;

        for(int i = 0; i < N; i++){
            int m = memory[i];
            int c = cost[i];

            for(int j = 0; j < sum+1; j++){
                if(i == 0) {
                    if(j >= c) dp[i][j] = m;
                }
                
                else{
                    if(j >= c) {
                        dp[i][j] = Math.max(dp[i-1][j-c] + m, dp[i-1][j]);
                    }
                    else {
                        dp[i][j] = dp[i-1][j];
                    }
                }

                if(dp[i][j] >= M) {
                    K = Math.min(K, j);
                }
            }

        }
        System.out.println(K);
    }
}