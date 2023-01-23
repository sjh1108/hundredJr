import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int max;
    
    static int[] f;
    static int[] arr;

    static Integer[][] dp;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        f = new int[N];
        dp = new Integer[N][K + 1];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            f[i] = Integer.parseInt(st.nextToken());
        }

        M = func(N - 1, K);

        System.out.println(M);
    }

    static int func(int i, int K){
        if(i < 0){
            return 0;
        }

        if(dp[i][K] == null){
            if(arr[i] > K){
                dp[i][K] = func(i - 1, K);
            }

            else{
                dp[i][K] = Math.max(func(i - 1, K), func(i - 1, K - arr[i]) + f[i]);
            }
        }

        return dp[i][K];
    }
}