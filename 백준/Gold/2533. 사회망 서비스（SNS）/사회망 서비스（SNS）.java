import java.io.*;
import java.util.*;

class Main {
    static HashMap<Integer, List<Integer>> map;
    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(i, new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map.get(a).add(b);
            map.get(b).add(a);
        }

        dp = new int[N][2];
        visited = new boolean[N];

        dfs(0); // 0번 노드를 root로 DFS 수행

        System.out.println(Math.min(dp[0][0], dp[0][1]));
    }

    static void dfs(int node) {
        visited[node] = true;
        dp[node][0] = 0; // node가 얼리어답터 아님
        dp[node][1] = 1; // node가 얼리어답터임

        for (int nxt : map.get(node)) {
            if (!visited[nxt]) {
                dfs(nxt);
                dp[node][0] += dp[nxt][1];
                dp[node][1] += Math.min(dp[nxt][0], dp[nxt][1]);
            }
        }
    }
}
