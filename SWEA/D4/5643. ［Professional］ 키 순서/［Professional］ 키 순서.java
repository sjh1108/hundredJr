import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

class Solution {

    private static List<Integer>[] tallerGraph;
    private static List<Integer>[] shorterGraph;
    private static int N;

    // startNode에서 출발하여 도달 가능한 노드의 수를 세는 BFS 함수
    private static int bfs(int startNode, List<Integer>[] graph) {
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[N + 1];
        
        queue.add(startNode);
        visited[startNode] = true;
        
        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            
            for (int neighbor : graph[current]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        // 자기 자신을 제외한 노드의 수를 반환
        return count - 1;
    }

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        // 입력 파일을 읽기 위한 설정 (제출 시에는 주석 처리)
        // System.setIn(new java.io.FileInputStream("sample_input.txt"));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            int M = sc.nextInt();

            // 그래프 초기화
            tallerGraph = new ArrayList[N + 1];
            shorterGraph = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                tallerGraph[i] = new ArrayList<>();
                shorterGraph[i] = new ArrayList<>();
            }

            // 간선 정보 입력
            for (int i = 0; i < M; i++) {
                int shorter = sc.nextInt();
                int taller = sc.nextInt();
                // shorter -> taller 관계
                tallerGraph[shorter].add(taller);
                // taller -> shorter 관계
                shorterGraph[taller].add(shorter);
            }
            
            int answer = 0;
            // 1번 학생부터 N번 학생까지 순회
            for (int i = 1; i <= N; i++) {
                // i보다 키가 큰 학생 수 계산
                int tallerCount = bfs(i, tallerGraph);
                // i보다 키가 작은 학생 수 계산
                int shorterCount = bfs(i, shorterGraph);

                // 두 합이 N-1이면 순위를 알 수 있음
                if (tallerCount + shorterCount == N - 1) {
                    answer++;
                }
            }

            System.out.println("#" + t + " " + answer);
        }

        sc.close();
    }
}