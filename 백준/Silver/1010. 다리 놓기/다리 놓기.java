import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dp;
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        dp = new int[31][31];

        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
    
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int tmp = bridge(m, n);

            sb.append(tmp);
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static int bridge(int n, int r){
        if(dp[n][r] > 0){
            return dp[n][r];
        }

        if(n == r || r == 0){
            return dp[n][r] = 1;
        }

        
        return dp[n][r] = bridge(n - 1, r - 1) + bridge(n - 1, r);
    }
}