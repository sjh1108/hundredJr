import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int[] p;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        p = new int[N+1];
        dp = new boolean[N+31][15001];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            p[i] = Integer.parseInt(st.nextToken());
        }
        DP(0, 0);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int w = Integer.parseInt(st.nextToken());
            if(w > 15000) sb.append("N ");
            else if(dp[N][w]) sb.append("Y ");
            else sb.append("N ");
        }
        System.out.println(sb);
    }

    static void DP(int idx, int weight){
        if(dp[idx][weight]) return;
        dp[idx][weight] = true;
        if(idx == N) return;

        DP(idx+1, weight+p[idx+1]);
        DP(idx+1, weight);
        DP(idx+1, Math.abs(weight-p[idx+1]));
    }
}