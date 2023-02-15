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
    final static int p = 1000000007;


    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] p1 = new int[N][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                p1[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        st.nextToken();
        K = Integer.parseInt(st.nextToken());
        dp = new int[N][K];
        int[][] p2 = new int[M][K];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < K; j++){
                p2[i][j] = Integer.parseInt(st.nextToken());

                for(int a = 0; a < N; a++){
                    dp[a][j] += p2[i][j] * p1[a][i];
                }
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < K; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

    }
}