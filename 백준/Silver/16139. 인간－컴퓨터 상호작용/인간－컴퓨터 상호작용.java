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

    static int[][] dp;

    public static void main(String[] args) throws IOException{
        String s = br.readLine();

        N = Integer.parseInt(br.readLine());

        dp = new int[s.length() + 1][26];
        
        for(int i = 1; i < s.length() + 1; i++){
            int x = s.charAt(i - 1) - 'a';
            dp[i] = dp[i - 1].clone();
            dp[i][x]++;
        }

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int c = st.nextToken().charAt(0) - 'a';

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int pivot = dp[end + 1][c] - dp[start][c];

            sb.append(pivot).append('\n');
        }

        System.out.println(sb);
    }

    static int func(int i, int j){
        return arr[j] - arr[i - 1];
    }
}