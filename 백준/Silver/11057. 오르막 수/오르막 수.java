import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        for(int i = 1; i <= N; i++){
            for(int j = 0; j < 10; j++){
                for(int k = 0; k <= j; k++){
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < 10; i++){
            ans += dp[N - 1][i];
            ans %= 10007;
        }
        System.out.println(ans);
    }
}