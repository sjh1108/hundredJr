import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            int[][] arr = new int[N][K];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[K + 1];
            for(int i = 0; i < N; i++){
                for(int j = K; j >= arr[i][0]; j--){
                    dp[j] = Math.max(dp[j], dp[j - arr[i][0]] + arr[i][1]);
                }
            }

            System.out.println("#" + t + " " + dp[K]);
        }
    }
}
