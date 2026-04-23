import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
        
        System.out.println(dp[len1][len2]);
	}
}