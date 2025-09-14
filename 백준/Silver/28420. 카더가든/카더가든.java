import java.util.*;
import java.io.*;

class Main{
    private static int N, M;
    private static int a, b, c;
    private static int min;
    
    private static int[][] map;
    private static int[][] dp;

    private static int dp(int x1, int y1, int x2, int y2){
        return dp[x2][y2] - dp[x1-1][y2] - dp[x2][y1 - 1] + dp[x1-1][y1-1];
    }

    private static void dp1(){
        for(int i = 1; i <= N - (a - 1); i++){
            for(int j = 1; j <= M - (b+c - 1); j++){
                int sum = dp(i, j, i + a - 1, j + b + c - 1);

                min = Math.min(min, sum);
            }
        }
    }
    private static void dp2(){
        for(int i = 1; i <= N - (a + b - 1); i++){
            for(int j = 1; j <= M - (a+c - 1); j++){
                int sum1 = dp(i, j, i + a - 1, j + c - 1);
                int sum2 = dp(i + a, j + c, i + a + b - 1, j + a + c - 1);

                int sum = sum1 + sum2;
                min = Math.min(min, sum);
            }
        }
    }
    private static void dp3(){
        for (int i = 1; i <= N - a - c + 1; i++) {
		    for (int j = 1; j <= M - b - a + 1; j++) {
                int sum1 = dp(i, j, i + a - 1, j + b - 1);
                int sum2 = dp(i + a, j + b, i + a + c - 1, j + a + b - 1);
                
                int sum = sum1 + sum2;
                
			    min = Math.min(min, sum);
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N+1][M+1];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                dp[i+1][j+1] = map[i][j] + dp[i+1][j] + dp[i][j+1] - dp[i][j];
            }
        }

        min = Integer.MAX_VALUE;

        dp1(); dp2(); dp3();

        System.out.println(min);
    }
}