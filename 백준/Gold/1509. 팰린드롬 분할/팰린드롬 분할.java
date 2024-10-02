import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;

    static char[] arr;
    static boolean[][] palindrome;

    static void input() throws IOException{
        String str = br.readLine();

        N = str.length();
        arr = new char[N+1];
        for(int i = 1; i <= N; i++){
            arr[i] = str.charAt(i-1);
        }
    }
    static void getPalindrome(){
        palindrome = new boolean[N+1][N+1];
        for(int i = 0; i < N+1; i++){
            palindrome[i][i] = true;

            if(i < N && arr[i] == arr[i+1]){
                palindrome[i][i+1] = true;
            }
        }

        for(int i = 2; i < N; i++){
            for(int j = 1; j + i <= N; j++){
                if(arr[j] == arr[j+i] && palindrome[j+1][j+i-1]){
                    palindrome[j][j+i] = true;
                }
            }
        }
    }
    static int solution(){
        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= i; j++){
                if(palindrome[j][i]){
                    dp[i] = Math.min(dp[i], dp[j-1] + 1);
                }
            }
        }

        return dp[N];
    }

    public static void main(String[] args) throws IOException{
        input();
        getPalindrome();
        System.out.println(solution());
    }
}