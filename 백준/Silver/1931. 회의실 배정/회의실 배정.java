import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M, K;
    
    static int[] arr;
    static boolean[] brr;

    static int[][] dp;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        dp = new int[N][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            dp[i][0] = Integer.parseInt(st.nextToken());
            dp[i][1] = Integer.parseInt(st.nextToken());
        }

        // sort with endTime
        Arrays.sort(dp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]) {
                    return o1[0]-o2[0];
                }
                return o1[1]-o2[1];
            }
        });


        // count : M, startTime : K
        M = 0;
        K = 0;
        brr = new boolean[dp[0][1] + 1];
        for(int i = 0; i < N; i++){
            // System.out.println(dp[i][0] + " " + dp[i][1]);
            
            if(K <= dp[i][0]){
                K = dp[i][1];
                M++;
            }

        }

        System.out.println(M);
    }
}