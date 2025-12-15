import java.io.*;
import java.util.*;

public class Main{
    private static final int INF = 1 << 28;

    private static int N, M, S, D;

    private static boolean[][] removed;
    private static List<List<int[]>> graph;
    private static List<Integer>[] parent;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N == 0 && M == 0) break;

            removed = new boolean[N][N];
            graph = new ArrayList<>();
            parent = new ArrayList[N];
            for(int i = 0; i < N; i++){
                graph.add(new ArrayList<>());
                parent[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            while(M-- > 0){
                st = new StringTokenizer(br.readLine());

                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                graph.get(u).add(new int[]{v, p});
            }

            dijkstra();
            removeShortestPath(S, D);
            sb.append(dijkstra() + "\n");
        }

        System.out.println(sb);
    }

    private static int dijkstra(){
        int[] dist = new int[N];
        Arrays.fill(dist, INF);

        dist[S] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        
        pq.add(new int[]{S, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            int from = cur[0];
            int cost = cur[1];

            if(cost > dist[from]) continue;

            for(int[] nxt: graph.get(from)){
                if(removed[from][nxt[0]]) continue;

                if(dist[nxt[0]] > dist[from] + nxt[1]){
                    dist[nxt[0]] = dist[from] + nxt[1];

                    parent[nxt[0]] = new ArrayList<>();
                    parent[nxt[0]].add(from);
                    pq.add(new int[]{nxt[0], dist[nxt[0]]});
                } else if(dist[nxt[0]] == dist[from] + nxt[1]){
                    parent[nxt[0]].add(from);
                }
            }
        }

        return dist[D] == INF ? -1 : dist[D];
    }

    private static void removeShortestPath(int s, int d){
        if(s == d) return;
                
        for(int n: parent[d]){
            if(!removed[n][d]){
                removed[n][d] = true;
                removeShortestPath(s, n);
            }
        }
    }
}