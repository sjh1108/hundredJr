import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, K;

    static int[] dp;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> tree;

    static int dfs(int cur){
        int cnt = 1;

        for(int next: tree.get(cur)){
            if(!visited[next]){
                visited[next] = true;

                cnt += dfs(next);
            }
        }

        return dp[cur] = cnt;
    }

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken()); 

        tree = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            tree.add(new ArrayList<>());
        }

        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        dp = new int[n+1];
        visited = new boolean[n+1];
        visited[r] = true;

        dfs(r);

        while(q-- > 0){
            int u = Integer.parseInt(br.readLine());
            sb.append(dp[u]).append('\n');
        }

        System.out.print(sb);
    }
}