import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 26076 - 곰곰이의 식단 관리 2 (ArrayDeque 버전)
 *
 * 가독성 우선 풀이.
 * 0-1 BFS로 (상/우 경계) → (하/좌 경계) 8방향 최단거리를 구한다.
 *   - 빈 칸: 비용 1
 *   - 장애물: 비용 0
 *   - (0,0), (N-1,M-1): 통과 불가
 */
public class Main {

    static final int INF = Integer.MAX_VALUE / 4;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // cost[r][c]: 0(장애물) / 1(빈 칸) / -1(통과 불가)
        int[][] cost = new int[N][M];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                int v = Integer.parseInt(st.nextToken());
                if ((r == 0 && c == 0) || (r == N - 1 && c == M - 1)) {
                    cost[r][c] = -1;
                } else {
                    cost[r][c] = (v == 1) ? 0 : 1;
                }
            }
        }

        int[][] dist = new int[N][M];
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) dist[r][c] = INF;
        }

        ArrayDeque<int[]> dq = new ArrayDeque<>();

        // TR 초기화: 1행 ∪ M열의 통과 가능 칸
        // - 1행
        for (int c = 0; c < M; c++) {
            tryRelax(0, c, cost[0][c], cost, dist, dq);
        }
        // - M열 (1행과 겹치는 (0, M-1)은 위에서 처리됨)
        for (int r = 1; r < N; r++) {
            tryRelax(r, M - 1, cost[r][M - 1], cost, dist, dq);
        }

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        int ans = INF;

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int r = cur[0], c = cur[1];
            int d = dist[r][c];

            // BL(N행 또는 1열) 도달?
            if (r == N - 1 || c == 0) {
                if (d < ans) ans = d;
            }

            for (int k = 0; k < 8; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (cost[nr][nc] < 0) continue;

                int nd = d + cost[nr][nc];
                if (nd < dist[nr][nc]) {
                    dist[nr][nc] = nd;
                    if (cost[nr][nc] == 0) dq.addFirst(new int[]{nr, nc});
                    else                   dq.addLast(new int[]{nr, nc});
                }
            }
        }

        System.out.println(ans);
    }

    /**
     * 가상 시작 노드 TR에서 (r, c)로 가는 거리(=cost[r][c])로 갱신 시도.
     * 통과 불가(cost = -1) 칸은 무시.
     */
    static void tryRelax(int r, int c, int costVal, int[][] cost, int[][] dist, ArrayDeque<int[]> dq) {
        if (costVal < 0) return;
        if (costVal < dist[r][c]) {
            dist[r][c] = costVal;
            if (costVal == 0) dq.addFirst(new int[]{r, c});
            else              dq.addLast(new int[]{r, c});
        }
    }
}