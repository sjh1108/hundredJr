import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;
    static int[] dp, coin;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        coin = new int[N+1];
        dp = new int[K+1];
        dp[0] = 1;

        for(int i = 1; i <= N; i++){
            coin[i] = Integer.parseInt(br.readLine());

            for(int j = coin[i]; j <= K; j++){
                dp[j] += dp[j - coin[i]];
            }
        }

        System.out.println(dp[K]);
    }
}