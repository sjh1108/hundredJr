import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];
        long k_1 = 0, k_2 = 0;
        long tmp;

        StringTokenizer st = new StringTokenizer(br.readLine());
        dp[1] = Integer.parseInt(st.nextToken());
        for(int t, i = 1; i < N; i++){
            t = Integer.parseInt(st.nextToken());
            tmp = Long.MIN_VALUE;
            
            for (int j = i; j >= 1; j--) {
                tmp = dp[j] > tmp ? dp[j] : tmp;
                dp[j + 1] = dp[j] + (j + 1) * t;
            }
            dp[0] = k_1 > k_2 ? k_1 : k_2;
            dp[1] = dp[0] + t;
            k_2 = k_1;
            k_1 = tmp;
        }
        tmp = k_1> k_2 ? k_1 : k_2;
        for (int i = 1; i <= N; i++)
            tmp = dp[i] > tmp ? dp[i] : tmp;

        System.out.println(tmp > 0 ? tmp : 0);
    }
}