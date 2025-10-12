import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] A; // 인접 리스트
    static BitSet[] memo;          // 각 노드에서 도달 가능한 노드 집합을 저장 (메모이제이션)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 1. 자료구조 초기화
        A = new ArrayList[N + 1];
        memo = new BitSet[N + 1]; // 결과를 저장할 BitSet 배열
        for (int i = 1; i <= N; i++) {
            A[i] = new ArrayList<>();
            memo[i] = new BitSet(N + 1);
        }

        // 2. 그래프 생성 (문제의 논리에 맞게 B -> A 방향으로)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            // A가 B를 신뢰 -> B를 해킹하면 A를 해킹할 수 있음 (B -> A)
            A[end].add(start);
        }

        int maxCount = 0;
        Queue<Integer> queue = new ArrayDeque<>(); // BFS를 위한 큐

        // 3. 모든 노드를 시작점으로 순차적으로 탐색 (1번부터 N번까지)
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
            memo[i].set(i); // 자기 자신은 항상 방문 가능

            while (!queue.isEmpty()) {
                int current = queue.poll();

                for (int next : A[current]) {
                    // 현재 시작점(i)에서 next를 이미 방문했다면 건너뛰기
                    if (memo[i].get(next)) {
                        continue;
                    }

                    // 4. 핵심 메모이제이션 로직
                    if (next < i) {
                        // 만약 next의 결과가 이미 계산되었다면 (next < i 이므로)
                        // 그 결과를 그대로 가져와 합친다 (중복 탐색 방지)
                        memo[i].or(memo[next]);
                    } else {
                        // 아직 계산되지 않은 노드는 직접 탐색
                        memo[i].set(next); // 방문 처리
                        queue.offer(next);   // 큐에 추가하여 탐색 계속
                    }
                }
            }
            // 현재까지의 최대 해킹 가능 컴퓨터 수 갱신
            maxCount = Math.max(maxCount, memo[i].cardinality());
        }

        // 5. 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (memo[i].cardinality() == maxCount) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}