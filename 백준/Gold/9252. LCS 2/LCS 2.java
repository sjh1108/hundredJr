import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        String s1 = br.readLine();
        String s2 = br.readLine();

        int l1 = s1.length(), l2 = s2.length();

        boolean[] check = new boolean[l1];
        int[][] dp = new int[l1+1][l2+1];
        for(int i = 0; i < l1; i++){
            for(int j = 0; j < l2; j++){
                if(s1.charAt(i) == s2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j] + 1;
                    check[i] = true;
                }
                else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        sb.append(dp[l1][l2]).append('\n');

        int i = l1, j = l2;
        Stack<Character> stack = new Stack<>();
        while(i > 0 && j > 0){
            if(dp[i][j] == dp[i-1][j]){
                i--;
            }
            else if(dp[i][j] == dp[i][j-1]){
                j--;
            }
            else{
                stack.push(s1.charAt(i-1));
                i--;
                j--;
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);
	}
}