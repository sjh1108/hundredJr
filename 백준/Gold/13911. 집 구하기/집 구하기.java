import java.io.*;
import java.util.*;

public class Main {
    // Edge 클래스는 Comparable을 구현하여 PriorityQueue에서 사용합니다.
    static class Edge implements Comparable<Edge> {
        int to;
        long weight;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight);
        }
    }

    // 그래프와 정점 개수를 전역 변수로 관리합니다.
    static ArrayList<ArrayList<Edge>> graph;
    static int V;
    static final long INF = Long.MAX_VALUE; // 충분히 큰 값으로 초기화

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            // 양방향 그래프 구성
            graph.get(start).add(new Edge(end, weight));
            graph.get(end).add(new Edge(start, weight));
        }

        // 맥도날드 정보 입력
        st = new StringTokenizer(br.readLine());
        int mCnt = Integer.parseInt(st.nextToken());
        int mLimit = Integer.parseInt(st.nextToken());
        int[] mList = new int[mCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < mCnt; i++) {
            mList[i] = Integer.parseInt(st.nextToken());
        }

        // 스타벅스 정보 입력
        st = new StringTokenizer(br.readLine());
        int sCnt = Integer.parseInt(st.nextToken());
        int sLimit = Integer.parseInt(st.nextToken());
        int[] sList = new int[sCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sCnt; i++) {
            sList[i] = Integer.parseInt(st.nextToken());
        }

        // 1. 맥도날드 기준으로 모든 정점까지의 최단 거리 계산
        long[] mMinDistance = dijkstra(mList);

        // 2. 스타벅스 기준으로 모든 정점까지의 최단 거리 계산
        long[] sMinDistance = dijkstra(sList);

        long minSum = INF;

        // 3. 모든 정점을 순회하며 최적의 '집'을 찾기
        for (int i = 1; i <= V; i++) {
            // 조건 1: 맥도날드나 스타벅스가 아닌 일반 정점(집)이어야 함
            //         (거리 값이 0이 아니라는 것으로 판별 가능)
            // 조건 2: 각 거리 제한(mLimit, sLimit)을 만족해야 함
            if (mMinDistance[i] > 0 && sMinDistance[i] > 0 &&
                mMinDistance[i] <= mLimit && sMinDistance[i] <= sLimit) {
                
                minSum = Math.min(minSum, mMinDistance[i] + sMinDistance[i]);
            }
        }

        // 조건을 만족하는 집이 없으면 -1, 있으면 최소 거리 합 출력
        if (minSum == INF) {
            System.out.println(-1);
        } else {
            System.out.println(minSum);
        }
    }

    /**
     * 다익스트라 알고리즘을 수행하여 시작 지점들로부터 모든 정점까지의 최단 거리를 계산합니다.
     * @param startNodes 시작 지점(맥도날드 또는 스타벅스) 목록
     * @return 각 정점까지의 최단 거리가 담긴 배열
     */
    static long[] dijkstra(int[] startNodes) {
        long[] dist = new long[V + 1];
        Arrays.fill(dist, INF);

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // 모든 시작 지점을 큐에 넣고, 거리를 0으로 초기화
        for (int node : startNodes) {
            dist[node] = 0;
            pq.add(new Edge(node, 0));
        }

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            
            // 이미 더 짧은 경로를 찾았다면 건너뛰기
            if (current.weight > dist[current.to]) {
                continue;
            }

            for (Edge next : graph.get(current.to)) {
                long newDist = current.weight + next.weight;
                
                // 더 짧은 경로를 발견하면 거리 갱신 및 큐에 추가
                if (newDist < dist[next.to]) {
                    dist[next.to] = newDist;
                    pq.add(new Edge(next.to, newDist));
                }
            }
        }
        return dist;
    }
}