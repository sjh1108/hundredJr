import java.io.*;
import java.util.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

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

        int[][] dp = new int[N][sum+1];
        int K = sum;

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