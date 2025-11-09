import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        int[][] mat = new int[501][2];
        int[][] dp = new int[501][501];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            mat[i][0] = Integer.parseInt(st.nextToken());
            mat[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < N; i++){
            for(int j = 1; j <= N - i; j++){
                int k = i + j;
                dp[j][k] = Integer.MAX_VALUE;

                for(int l = j; l < k; l++){
                    dp[j][k] = Math.min(dp[j][k], dp[j][l] + dp[l + 1][k] + mat[j][0] * mat[l][1] * mat[k][1]);
                }
            }
        }

        System.out.println(dp[1][N]);
        // System.out.println(sb);
    }
}