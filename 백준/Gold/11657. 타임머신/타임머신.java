import java.util.*;
import java.io.*;

public class Main{
    static class Node{
        int to;
        int cost;

        public Node(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
    }

    private static final long INF = 1L << 40;

    private static int N, M;

    private static long[] dist;
    private static List<List<Node>> list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dist = new long[N+1];

        list = new ArrayList<>();
        Arrays.fill(dist, INF);
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(from).add(new Node(to, cost));
        }

        StringBuilder sb = new StringBuilder();
        if(bellmanFord()) sb.append(-1).append("\n");
        else{
            for(int i = 2; i <= N; i++){
                if(dist[i] == INF){
                    sb.append(-1);
                } else{
                    sb.append(dist[i]);
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }

    private static boolean bellmanFord(){
        dist[1] = 0;
        boolean update = false;

        for(int i = 1; i < N; i++){
            update = false;

            for(int j = 1; j <= N; j++){
                for(Node n: list.get(j)){
                    if(dist[j] == INF)
                        break;

                    if(dist[n.to] > dist[j] + n.cost){
                        dist[n.to] = dist[j] + n.cost;
                        update = true;
                    }
                }
            }
        }

        if(update){
            for(int i = 1; i <= N; i++){
                for(Node n : list.get(i)){
                    if(dist[i] == INF)
                        break;

                    if(dist[n.to] > dist[i] + n.cost)
                        return true;
                }
            }
        }

        return false;
    }
}