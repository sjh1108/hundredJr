import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    static boolean[] visited;
    static int[] distance;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        int loop = Integer.parseInt(br.readLine());

        for (; loop > 0; loop--) {
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            dp();
        }

        System.out.println(sb);
    }

    static void dp() {
        int[] arr = new int[N + 1];
        int[] sum = new int[N + 1];
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + arr[i];
        }

        for (int n = 1; n <= N; n++) {
            for (int from = 1; from + n <= N; from++) {
                int to = from + n;
                dp[from][to] = Integer.MAX_VALUE;
                for (int divide = from; divide < to; divide++) {
                    dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + sum[to] - sum[from - 1]);
                }
            }
        }

        sb.append(dp[1][N]).append("\n");
    }
}
