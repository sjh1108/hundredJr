import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static boolean[] visited;
    static int INF = 100000001;
    static int start, end;
    static int[] dist, route;
    static ArrayList<Node>[] list;

    static class Node implements Comparable<Node>{
        int e, cost;

        public Node(int e, int cost){
            this.e = e;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, cost));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        route = new int[N + 1];
        visited = new boolean[N + 1];
        dijkstra();

        sb.append(dist[end]).append("\n");

        ArrayList<Integer> path = new ArrayList<>();
        int cur = end;
        while(cur != 0){
            path.add(cur);
            cur = route[cur];
        }
        sb.append(path.size()).append("\n");
        for(int i = path.size() - 1; i >= 0; i--){
            sb.append(path.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    static void dijkstra(){
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.add(new Node(start, 0));
        dist[start] = 0;
        route[start] = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();

            if(!visited[cur.e]) visited[cur.e] = true;
            else continue;

            for(int i = 0; i < list[cur.e].size(); i++) {
                Node next = list[cur.e].get(i);
                if(dist[next.e] > dist[cur.e] + next.cost) {
                    dist[next.e] = dist[cur.e] + next.cost;
                    q.offer(new Node(next.e, dist[next.e]));
                    route[next.e] = cur.e;
                }
            }
        }
    }
}