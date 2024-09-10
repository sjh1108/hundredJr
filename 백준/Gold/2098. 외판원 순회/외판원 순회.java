import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, K;

    static int[][] map;
    static int[][] dp;

    static final int max = 1_000_000_000;
    static int dfs(int cur, int visit){
        if(visit == (1 << N) - 1){
            if(map[cur][0] != 0){
                return map[cur][0];
            } else{
                return max;
            }
        }

        if(dp[cur][visit] != -1){
            return dp[cur][visit];
        }
        dp[cur][visit] = max;

        for(int i = 0; i < N; i++){
            if((visit & (1 << i)) == 0 && map[cur][i] != 0){
                dp[cur][visit] = Math.min(dfs(i, visit | (1 << i)) + map[cur][i], dp[cur][visit]);
            }
        }
        
        return dp[cur][visit];
    }

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[N][1<<N];
        for(int i = 0; i < N; i++){
            Arrays.fill(dp[i], -1);
        }

        System.out.println(dfs(0, 1));
    }

}