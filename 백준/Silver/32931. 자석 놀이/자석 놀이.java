import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        long[][] map = new long[2][N+1];
        for(int i = 0; i < 2; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[2][N+1];

        dp[0][1] = Math.max(0, map[1][1]) + map[0][1];
        dp[1][1] = map[0][1] + map[1][1];

        for(int i = 2; i <= N; i++){
            dp[0][i] = Math.max(dp[0][i-1], Math.max(dp[0][i-1], dp[1][i-1]) + map[1][i]) + map[0][i];
            dp[1][i] = Math.max(dp[1][i-1], Math.max(dp[0][i-1], dp[1][i-1]) + map[0][i]) + map[1][i];
        }

        System.out.println(dp[1][N]);
    }
}