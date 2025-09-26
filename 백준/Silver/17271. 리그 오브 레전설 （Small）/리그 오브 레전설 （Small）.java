import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int mod = 1_000_000_007;

        int[] dp = new int[N+1];
        dp[0] = 1;
        for(int i = 1; i <= N; i++){
            dp[i] = dp[i-1];
            if(i-M < 0) continue;
            dp[i] += dp[i-M];
            dp[i] %= mod;
        }

        System.out.println(dp[N]);
        sc.close();
    }
}