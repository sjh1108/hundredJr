import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int V; // 정점의 개수
    static List<List<Edge>> adjList; // 인접 리스트
    static final long INF = Long.MAX_VALUE;

    // 간선 정보를 담는 클래스
    static class Edge implements Comparable<Edge> {
        int to;
        long cost;

        public Edge(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        adjList = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<>());
        }

        // 도로 정보 입력 (양방향)
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            adjList.get(u).add(new Edge(v, w));
            adjList.get(v).add(new Edge(u, w));
        }

        // 맥도날드 정보 입력
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] mcdonalds = new int[M];
        Set<Integer> mcSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            mcdonalds[i] = Integer.parseInt(st.nextToken());
            mcSet.add(mcdonalds[i]);
        }

        // 스타벅스 정보 입력
        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[] starbucks = new int[S];
        Set<Integer> starSet = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < S; i++) {
            starbucks[i] = Integer.parseInt(st.nextToken());
            starSet.add(starbucks[i]);
        }

        // 다익스트라 실행
        long[] distFromMc = dijkstra(mcdonalds);
        long[] distFromStar = dijkstra(starbucks);

        long minSum = INF;

        // 최적의 집 찾기
        for (int i = 1; i <= V; i++) {
            // 맥도날드나 스타벅스가 아닌 '집' 중에서
            if (!mcSet.contains(i) && !starSet.contains(i)) {
                // 거리 제한 조건을 만족하는 경우
                if (distFromMc[i] <= x && distFromStar[i] <= y) {
                    minSum = Math.min(minSum, distFromMc[i] + distFromStar[i]);
                }
            }
        }

        // 결과 출력
        if (minSum == INF) {
            System.out.println(-1);
        } else {
            System.out.println(minSum);
        }
    }

    // 다수의 시작점에서부터의 최단 거리를 구하는 다익스트라 메소드
    private static long[] dijkstra(int[] startNodes) {
        long[] dist = new long[V + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // 모든 시작점을 우선순위 큐에 추가
        for (int startNode : startNodes) {
            dist[startNode] = 0;
            pq.add(new Edge(startNode, 0));
        }

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.to;
            long cost = current.cost;

            if (dist[u] < cost) {
                continue;
            }

            for (Edge next : adjList.get(u)) {
                int v = next.to;
                long newDist = cost + next.cost;

                if (dist[v] > newDist) {
                    dist[v] = newDist;
                    pq.add(new Edge(v, newDist));
                }
            }
        }

        return dist;
    }
}