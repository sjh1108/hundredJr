import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] adj;
    static long maxTime = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        adj = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            adj[u][v] = Math.max(adj[u][v], d);
        }

        for (int i = 1; i <= N; i++) {
            if (adj[0][i] > 0) {
                dfs(i, 1, (1 << i), adj[0][i]);
            }
        }

        System.out.println(maxTime);
    }

    private static void dfs(int current, int count, int visited, long time) {
        if (count == N) {
            if (adj[current][0] > 0) {
                long totalTime = time + adj[current][0];
                maxTime = Math.max(maxTime, totalTime);
            }
            return;
        }

        for (int next = 1; next <= N; next++) {
            if (adj[current][next] > 0 && (visited & (1 << next)) == 0) {
                dfs(next, count + 1, visited | (1 << next), time + adj[current][next]);
            }
        }
    }
}