import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    static final int INF = 987654321;
    static int k;
    static ArrayList<ArrayList<Node>> graph;

    static class Node{
        int idx, cost;

        Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
    
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        k = Integer.parseInt(br.readLine());
        graph = new ArrayList<ArrayList<Node>>();
        for(int i = 0; i < N + 1; i++){
            graph.add(new ArrayList<Node>());
        }
        for(int  i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, cost));
        }

        int[] dist = new int[N + 1];
        for(int i = 0; i < N + 1; i++){
            dist[i] = INF;
        }

        PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
        q.offer(new Node(k, 0));
        dist[k] = 0;
        while(!q.isEmpty()){
            Node curNode = q.poll();

            if(dist[curNode.idx] < curNode.cost) continue;
            for(int i = 0; i < graph.get(curNode.idx).size(); i++){
                Node nxtNode = graph.get(curNode.idx).get(i);

                if(dist[nxtNode.idx] > curNode.cost + nxtNode.cost){
                    dist[nxtNode.idx] = curNode.cost + nxtNode.cost;
                    q.offer(new Node(nxtNode.idx, dist[nxtNode.idx]));
                }
            }
        }

        for(int i = 1; i < N + 1; i++){
            if(dist[i] == INF) sb.append("INF\n");
            else sb.append(dist[i] + "\n");
        }
        System.out.println(sb);
    }
}
