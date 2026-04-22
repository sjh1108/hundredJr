import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        StringBuilder sb = new StringBuilder();

        in.nextToken();
        int T = (int) in.nval;

        while (T-- > 0) {
            in.nextToken(); int N = (int) in.nval;
            in.nextToken(); int K = (int) in.nval;

            int[] delay = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                in.nextToken();
                delay[i] = (int) in.nval;
            }

            int[] head = new int[N + 1];
            int[] next = new int[K + 1];
            int[] to = new int[K + 1];
            int[] inDeg = new int[N + 1];
            Arrays.fill(head, -1);

            for (int e = 1; e <= K; e++) {
                in.nextToken(); int x = (int) in.nval;
                in.nextToken(); int y = (int) in.nval;
                to[e] = y;
                next[e] = head[x];
                head[x] = e;
                inDeg[y]++;
            }

            in.nextToken();
            int W = (int) in.nval;

            int[] dp = new int[N + 1];
            int[] queue = new int[N];
            int qh = 0, qt = 0;
            for (int i = 1; i <= N; i++) {
                dp[i] = delay[i];
                if (inDeg[i] == 0) queue[qt++] = i;
            }

            while (qh < qt) {
                int u = queue[qh++];
                if (u == W) break;
                for (int e = head[u]; e != -1; e = next[e]) {
                    int v = to[e];
                    if (dp[u] + delay[v] > dp[v]) dp[v] = dp[u] + delay[v];
                    if (--inDeg[v] == 0) queue[qt++] = v;
                }
            }

            sb.append(dp[W]).append('\n');
        }

        System.out.print(sb);
    }
}
