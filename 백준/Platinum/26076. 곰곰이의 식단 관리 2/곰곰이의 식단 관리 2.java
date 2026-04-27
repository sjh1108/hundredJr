import java.io.*;
import java.util.*;

class Main {
    private static final int INF = Integer.MAX_VALUE / 4;

    private static int N, M;

    private static int[][] cost;
    private static int[][] dist;

    private static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    private static Deque<int[]> dq = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cost = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int v = Integer.parseInt(st.nextToken());
                if ((i == 0 && j == 0) || (i == N - 1 && j == M - 1)) {
                    cost[i][j] = -1;
                } else {
                    cost[i][j] = (v == 1) ? 0 : 1;
                }
            }
        }

        dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], INF);
        }

        dq = new ArrayDeque<>();
        for (int i = 0; i < M; i++){
            addQueue(0, i, cost[0][i]);
        }
        
        for(int i = 0; i < N; i++){
            addQueue(i, M - 1, cost[i][M - 1]);
        }

        int ans = INF;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0], y = cur[1];
            int d = dist[x][y];

            if (x == N - 1 || y == 0) {
                if (d < ans) ans = d;
            }

            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (isOut(nx, ny)) continue;
                if (cost[nx][ny] < 0) continue;

                int c = cost[nx][ny];
                int nd = d + c;
                if (nd < dist[nx][ny]) {
                    dist[nx][ny] = nd;
                    if (c == 0) dq.addFirst(new int[]{nx, ny});
                    else        dq.addLast(new int[]{nx, ny});
                }
            }
        }

        System.out.println(ans);
    }

    private static void addQueue(int r, int c, int costVal) {
        if (costVal < 0) return;
        if (costVal < dist[r][c]) {
            dist[r][c] = costVal;
            if (costVal == 0) dq.addFirst(new int[]{r, c});
            else              dq.addLast(new int[]{r, c});
        }
    }

    private static boolean isOut(int x, int y){
        return x < 0 || x >= N || y < 0 || y >= M;
    }
}