import java.io.*;
import java.util.*;

class Main {
    private static final int MAX_N = 100_002;
    private static final int MAX_A = 26;
    private static final int MOD = 1_000_000_007;

    private static int K, N;
    private static long ans;

    private static boolean[][] comb;
    private static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        comb = new boolean[MAX_A][MAX_A];
        dp = new long[MAX_N][MAX_A];

        for(int i = 0; i < K; i++){
            String input = br.readLine();

            comb[input.charAt(0) - 'a'][input.charAt(1) - 'a'] = true;
        }

        for(int i = 2; i <= N; i++){
            for (int j = 0; j < MAX_A; j++) {
                for (int k = 0; k < MAX_A; k++) {
                    if (comb[j][k]) {
                        dp[i][j] += ((dp[i - 1][k] + 1) % MOD);
                        dp[i][j] %= MOD;
                    }
                }
            }
        }
        
        for (int i = 0; i < MAX_A; i++) {
            ans += dp[N][i];
            ans %= MOD;
        }

        System.out.println(ans % MOD);
    }
}
