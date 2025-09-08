import java.util.*;
import java.io.*;

public class Main{
    private static int N, M;

    private static int[] dist;
    private static List<List<Edge>> graph = new ArrayList<>();
    private static Queue<Edge> pq = new PriorityQueue<>();

    private static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.weight, o.weight);
        }
    }

    private static void dijkstra(int start, int end){
        dist[start] = 0;
        pq.offer(new Edge(-1, start, 0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(dist[cur.to] < cur.weight) continue;

            for(Edge next : graph.get(cur.to)){
                if(dist[next.to] > dist[cur.to] + next.weight){
                    dist[next.to] = dist[cur.to] + next.weight;
                    pq.offer(new Edge(next.from, next.to, dist[next.to]));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        StringTokenizer st;

        graph = new ArrayList<>();
        for(int i=0; i<N; i++) graph.add(new ArrayList<>());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken())   - 1;
            int weight = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Edge(from, to, weight));
        }

        dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken()) - 1;
        int to = Integer.parseInt(st.nextToken()) - 1;

        dijkstra(from, to);

        System.out.println(dist[to]);
    }
}