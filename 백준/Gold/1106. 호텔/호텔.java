import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] cost = new int[N];
        int[] people = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i] = Integer.parseInt(st.nextToken());
            people[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[C + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= C; i++) {
            for (int j = 0; j < N; j++) {
                int prev = Math.max(0, i - people[j]);
                if (dp[prev] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[prev] + cost[j]);
                }
            }
        }

        System.out.println(dp[C]);
    }
}
