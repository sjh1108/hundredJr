import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    static int TC;
    static int n, m, w;
    static ArrayList<ArrayList<Node>> list;
    static class Node{
        int end, cost;
        Node(int end, int cost){
            this.end = end;
            this.cost = cost;
        }
    }
    static int[] dist;
    static boolean[] visited;
    final static int INF = 1000000000;

    public static void main(String[] args) throws IOException{
        TC = Integer.parseInt(br.readLine());

        while(TC-- > 0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            dist = new int[n + 1];
            visited = new boolean[n + 1];

            list = new ArrayList<>();
            for(int i = 0; i <= n; i++) list.add(new ArrayList<>());

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                list.get(s).add(new Node(e, t));
                list.get(e).add(new Node(s, t));
            }
            for(int i = 0; i < w; i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                list.get(s).add(new Node(e, -t));
                visited[s] = true;
            }

            sb.append(bellmanFord() ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }

    static boolean bellmanFord(){
        for(int i = 0; i <= n; i++) dist[i] = INF;
        dist[1] = 0;
        boolean update = false;

        for(int i = 1; i < n; i++){
            update = false;

            for(int j = 1; j <= n; j++){
                for(Node node : list.get(j)){
                    if(dist[node.end] > dist[j] + node.cost){
                        dist[node.end] = dist[j] + node.cost;
                        update = true;
                    }
                }

            }
            
            if(!update) break;
        }

        if(update){
            for(int i = 1; i <= n; i++){
                for(Node node : list.get(i)){
                    if(dist[node.end] > dist[i] + node.cost){
                        return true;
                    }
                }
            }
        }

        return false;
    }
}