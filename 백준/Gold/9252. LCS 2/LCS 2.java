import java.util.*;
import java.io.*;

class Main{

    static int N, M;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();

        int len1 = s1.length, len2 = s2.length;

        boolean[] check = new boolean[len1];
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                if(s1[i] == s2[j]){
                    dp[i+1][j+1] = dp[i][j] + 1;
                    check[i] = true;
                }
                else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        sb.append(dp[len1][len2]).append('\n');

        int i = len1, j = len2;
        Deque<Character> stack = new ArrayDeque<>();
        while(i > 0 && j > 0){
            if(dp[i][j] == dp[i-1][j]){
                --i;
            }
            else if(dp[i][j] == dp[i][j-1]){
                --j;
            }
            else{
                stack.push(s1[--i]);
                --j;
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);
	}
}