import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] ans;
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ans = new int[n + 1][m + 1];

        System.out.println(pascal(n, m));
    }

    static int pascal(int n, int k){
        if(ans[n][k] > 0){
            return ans[n][k];
        }

        if(n == k || k == 0){
            return ans[n][k] = 1;
        }

        ans[n][k] = (pascal(n - 1, k - 1) + pascal(n - 1, k)) % 10007;
        return ans[n][k];
    }

    static int gcd(int p, int q){
        if(q == 0) return p;
        return gcd(q, p % q);
    }
}