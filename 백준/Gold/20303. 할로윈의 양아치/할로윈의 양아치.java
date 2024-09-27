import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;

    static int[] candy;
    static int[] parent;
    static int[] count;

    static int[] dp;

    static List<int[]> list = new ArrayList<>();

    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a < b) {
            parent[b] = a;
            candy[a] += candy[b];
            count[a] += count[b];
        }
        else if(a == b){
            return;
        }
        else {
            parent[a] = b;
            candy[b] += candy[a];
            count[b] += count[a];
        }
    }
    
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        candy = new int[N+1];
        parent = new int[N+1];
        count = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            candy[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
            count[i] = 1;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        for(int i = 1; i < N+1; i++){
            if(parent[i] == i) list.add(new int[]{count[i], candy[i]});
        }

        dp = new int[K];
        for(int[] countCandy: list){
            int count = countCandy[0];
            int candy = countCandy[1];
            for(int i = K-1; i >= count; i--){
                dp[i] = Math.max(dp[i], dp[i-count] + candy);
            }
        }

        System.out.println(dp[K-1]);
    }
}