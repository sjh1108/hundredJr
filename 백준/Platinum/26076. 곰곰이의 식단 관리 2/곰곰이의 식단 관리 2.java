import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.StreamTokenizer;

/**
 * 26076 - 곰곰이의 식단 관리 2
 *
 * 풀이:
 *   - 빈 칸: 비용 1, 장애물: 비용 0, (0,0)/(N-1,M-1): 통과 불가
 *   - 가상 시작점 = 상/우 경계, 가상 끝점 = 하/좌 경계
 *   - 8방향 인접으로 0-1 BFS → 최단거리 = 추가로 놓아야 할 장애물 최소 개수
 *
 * 최적화:
 *   - StreamTokenizer로 입력 파싱
 *   - int 배열 기반 원형 deque (객체 할당 0)
 *   - 1차원 배열로 격자/거리 저장
 */
public class Main {

    public static void main(String[] args) throws IOException {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        in.nextToken(); int N = (int) in.nval;
        in.nextToken(); int M = (int) in.nval;

        int total = N * M;
        // cost[i] = 0(장애물) / 1(빈 칸) / -1(통과 불가)
        byte[] cost = new byte[total];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                in.nextToken();
                int v = (int) in.nval;
                int idx = r * M + c;
                if ((r == 0 && c == 0) || (r == N - 1 && c == M - 1)) {
                    cost[idx] = -1;
                } else {
                    cost[idx] = (byte) (v == 1 ? 0 : 1);
                }
            }
        }

        final int INF = Integer.MAX_VALUE / 4;
        int[] dist = new int[total];
        for (int i = 0; i < total; i++) dist[i] = INF;

        // 원형 int deque
        // deque에 들어갈 수 있는 노드 수의 상한: 각 칸은 최대 한 번만 "최종 거리"가 확정되지만,
        // 같은 칸이 더 작은 거리로 갱신되면서 여러 번 들어갈 수 있다.
        // 안전하게 capacity = total * 4로 잡는다 (4*4*10^6 = 16*10^6 int = 64MB). 
        // 메모리 절약을 위해 더 작은 값 + 모듈러 인덱싱.
        int cap = Math.max(16, total * 2);
        int[] dq = new int[cap];
        int head = 0, tail = 0;  // [head, tail) 모듈러 cap

        // TR(상/우 경계) 초기화: 1행과 M열의 통과 가능 칸을 비용만큼 거리로 두고 큐 삽입
        for (int c = 0; c < M; c++) {
            int idx = c;
            if (cost[idx] < 0) continue;
            int d = cost[idx];
            if (d < dist[idx]) {
                dist[idx] = d;
                if (d == 0) {
                    head = (head - 1 + cap) % cap;
                    dq[head] = idx;
                } else {
                    dq[tail] = idx;
                    tail = (tail + 1) % cap;
                }
            }
        }
        for (int r = 1; r < N; r++) {
            int idx = r * M + (M - 1);
            if (cost[idx] < 0) continue;
            int d = cost[idx];
            if (d < dist[idx]) {
                dist[idx] = d;
                if (d == 0) {
                    head = (head - 1 + cap) % cap;
                    dq[head] = idx;
                } else {
                    dq[tail] = idx;
                    tail = (tail + 1) % cap;
                }
            }
        }

        int ans = INF;

        while (head != tail) {
            int cur = dq[head];
            head = (head + 1) % cap;
            int d = dist[cur];
            int r = cur / M;
            int c = cur % M;

            // 처리 시점 거리가 stale이면 skip (deque에 중복 삽입됐을 수 있음)
            // 위 코드 흐름상 거리 갱신 시에만 삽입하므로, 꺼낼 때 dist[cur]보다 큰 d로 들어왔을 수 있음.
            // 하지만 우리는 d = dist[cur]로 바로 읽고 있어서 항상 최신값이 사용됨.
            // 단, dist가 더 작아진 후 큐에서 다시 같은 노드를 만나면 처리는 한 번 더 일어나지만
            // 더 이상 갱신은 일어나지 않음(인접한 모든 노드의 거리가 이미 작거나 같음).

            if (r == N - 1 || c == 0) {
                if (d < ans) ans = d;
            }

            // 8방향
            int rm1 = r - 1, rp1 = r + 1;
            int cm1 = c - 1, cp1 = c + 1;

            for (int nr = rm1; nr <= rp1; nr++) {
                if (nr < 0 || nr >= N) continue;
                int base = nr * M;
                for (int nc = cm1; nc <= cp1; nc++) {
                    if (nc < 0 || nc >= M) continue;
                    if (nr == r && nc == c) continue;
                    int nidx = base + nc;
                    byte cc = cost[nidx];
                    if (cc < 0) continue;
                    int nd = d + cc;
                    if (nd < dist[nidx]) {
                        dist[nidx] = nd;
                        if (cc == 0) {
                            head = (head - 1 + cap) % cap;
                            dq[head] = nidx;
                        } else {
                            dq[tail] = nidx;
                            tail = (tail + 1) % cap;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}