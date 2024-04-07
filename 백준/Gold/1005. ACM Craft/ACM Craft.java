import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    static class Node{
        List<Node> head = new ArrayList<>();
        int cost, idx;

        public Node(int cost, int idx){
            this.cost = cost;
            this.idx = idx;
        }
    }
    static Node[] nodes;
    static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            nodes = new Node[N+1];
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= N; i++){
                nodes[i] = new Node(Integer.parseInt(st.nextToken()), i);
            }

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int before = Integer.parseInt(st.nextToken());
                int after = Integer.parseInt(st.nextToken());
                
                nodes[after].head.add(nodes[before]);
            }

            visited = new boolean[N+1];
            int W = Integer.parseInt(br.readLine());
            sb.append(dfs(W)).append("\n");
        }

        System.out.println(sb);
    }

    static int dfs(int idx){
        if(visited[idx]) return nodes[idx].cost;

        visited[idx] = true;
        int max = 0;
        for(Node node : nodes[idx].head){
            max = Math.max(max, dfs(node.idx));
        }

        return nodes[idx].cost += max;
    }
}