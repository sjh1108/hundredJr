import java.io.*;
import java.util.*;

class Main {

    static class Node implements Comparable<Node>{
        int to,cnt;
        long cost;

        public Node(int node, long weight, int cnt) {
            this.to = node;
            this.cnt = cnt;
            this.cost = weight;
        }

        @Override
        public int compareTo(Node n){
            return Long.compare(this.cost, n.cost);
        }
    }

    private static int N, M, K;

    private static List<List<Node>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, c, 0));
            graph.get(e).add(new Node(s, c, 0));
        }

        System.out.println(dijkstra());
    }

    private static long dijkstra(){
        long[][] dist = new long[N+1][K+1];

        for(long[] d: dist){
            Arrays.fill(d, Long.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[1][0] = 0;
        pq.add(new Node(1, 0, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            if(dist[cur.to][cur.cnt] < cur.cost) continue;

            for (Node nxt : graph.get(cur.to)) {
                if(cur.cnt < K && dist[nxt.to][cur.cnt + 1] > dist[cur.to][cur.cnt]){
                    dist[nxt.to][cur.cnt + 1] = dist[cur.to][cur.cnt];

                    pq.add(new Node(nxt.to, dist[nxt.to][cur.cnt + 1], cur.cnt + 1));
                }

                if(dist[nxt.to][cur.cnt] > dist[cur.to][cur.cnt] + nxt.cost){
                    dist[nxt.to][cur.cnt] = dist[cur.to][cur.cnt] + nxt.cost;
                    
                    pq.add(new Node(nxt.to, dist[nxt.to][cur.cnt], cur.cnt));
                }
            }
        }

        long min = Long.MAX_VALUE;
        for(long d: dist[N]){
            min = Math.min(min, d);
        }
        return min;
    }
}