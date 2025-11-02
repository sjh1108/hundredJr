import java.io.*;
import java.util.*;

class Main {
    private static final int MAX_N = 146858;
	private static int[] six_angle = new int[MAX_N + 1];
	private static int[] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        prefix();

		dp = new int[N + 1];
		Arrays.fill(dp, MAX_N);
		dp[0] = 0;
		dp[1] = 1;

		for (int i = 2; i <= N; i++) {
			for (int j = 1; j <= i; j++) {
				if (six_angle[j] > i) break;
                
				if (dp[i] > dp[i - six_angle[j]] + 1) {
					dp[i] = dp[i - six_angle[j]] + 1;
				}
			}
		}
		System.out.println(dp[N]);
    }

    private static void prefix() {
		six_angle[1] = 1;
		for (int i = 2; i <= MAX_N; i++) {
			six_angle[i] = (i - 1) * 6 + six_angle[i - 1] - (2 * (i - 1) - 1);
		}
	}
}