import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        int[][] arr;
        long[][] dp;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        dp = new long[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        dp[0][0] = 1;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                int jump = arr[i][j];
                if(jump == 0) continue;

                if(i + jump < N){
                    dp[i + jump][j] += dp[i][j];
                }
                if(j + jump < N){
                    dp[i][j + jump] += dp[i][j];
                }
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}