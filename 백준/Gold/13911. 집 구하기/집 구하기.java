import java.io.*;
import java.util.*;

public class Main {
    // ArrayDeque는 정렬을 하지 않으므로 Comparable 구현이 필요 없습니다.
    static class Edge {
        int to;
        long weight;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static ArrayList<ArrayList<Edge>> graph;
    static int V;
    static final long INF = Long.MAX_VALUE;

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

        // 1. 맥도날드 기준 최단 거리 계산 (BFS 방식)
        long[] mMinDistance = bfs(mList);

        // 2. 스타벅스 기준 최단 거리 계산 (BFS 방식)
        long[] sMinDistance = bfs(sList);

        long minSum = INF;

        // 3. 모든 정점을 순회하며 최적의 '집'을 찾기
        for (int i = 1; i <= V; i++) {
            if (mMinDistance[i] > 0 && sMinDistance[i] > 0 &&
                mMinDistance[i] <= mLimit && sMinDistance[i] <= sLimit) {
                minSum = Math.min(minSum, mMinDistance[i] + sMinDistance[i]);
            }
        }

        if (minSum == INF) {
            System.out.println(-1);
        } else {
            System.out.println(minSum);
        }
    }

    /**
     * ArrayDeque를 사용한 BFS 방식으로 최단 거리를 계산합니다.
     * @param startNodes 시작 지점(맥도날드 또는 스타벅스) 목록
     * @return 각 정점까지의 최단 거리가 담긴 배열
     */
    static long[] bfs(int[] startNodes) {
        long[] dist = new long[V + 1];
        Arrays.fill(dist, INF);

        // PriorityQueue 대신 ArrayDeque 사용
        ArrayDeque<Edge> q = new ArrayDeque<>();

        for (int node : startNodes) {
            dist[node] = 0;
            q.offer(new Edge(node, 0));
        }

        while (!q.isEmpty()) {
            Edge current = q.poll();
            
            // 큐에서 꺼낸 경로가 이미 기록된 최단 경로보다 길다면 건너뜁니다.
            // 이 부분이 없으면 시간 초과가 발생할 수 있습니다.
            if (current.weight > dist[current.to]) {
                continue;
            }

            for (Edge next : graph.get(current.to)) {
                long newDist = current.weight + next.weight;
                
                if (newDist < dist[next.to]) {
                    dist[next.to] = newDist;
                    q.offer(new Edge(next.to, newDist));
                }
            }
        }
        return dist;
    }
}