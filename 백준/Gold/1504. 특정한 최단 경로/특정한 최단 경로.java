import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static class Node implements Comparable<Node>{
        int to, cost;
        Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }
    static ArrayList<ArrayList<Node>> list;
    static int INF = 200000000;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        dist = new int[N+1]; visited = new boolean[N+1];

        list = new ArrayList<>();
        for(int i = 0; i <= N; i++) list.add(new ArrayList<>());
        Arrays.fill(dist, INF);

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(from).add(new Node(to, cost));
            list.get(to).add(new Node(from, cost));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken()); int v2 = Integer.parseInt(st.nextToken());

        // 0 -> v1 -> v2 -> N-1 : res1
        // 0 -> v2 -> v1 -> N-1 : res2
        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);

        
        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);

        System.out.println(Math.min(res1, res2) >= INF ? -1 : Math.min(res1, res2));
    }

    static int dijkstra(int start, int end){
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0)); 
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(!visited[cur.to]){
                visited[cur.to] = true;

                for(Node next : list.get(cur.to)){
                    if(dist[next.to] > dist[cur.to] + next.cost){
                        dist[next.to] = dist[cur.to] + next.cost;
                        pq.add(new Node(next.to, dist[next.to]));
                    }
                }
            }
        }

        return dist[end];
    }
}