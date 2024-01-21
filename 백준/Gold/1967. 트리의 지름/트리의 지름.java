import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static class Node{
        int num, len;

        Node(int num, int len){
            this.num = num;
            this.len = len;
        }
    }

    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int ans;
    
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];

        for(int i=1; i<=N; i++) 
            list[i] = new ArrayList<>();

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to, len));
            list[to].add(new Node(from, len));
        }

        ans = 0;

        for(int i = 1; i <= N; i++){
            visited = new boolean[N+1];
            visited[i] = true;
            dfs(i, 0);
        }

        System.out.println(ans);
        
    }

    static void dfs(int num, int dim){
        for(Node node : list[num]){
            if(!visited[node.num]){
                visited[node.num] = true;
                dfs(node.num, dim + node.len);
            }
        }

        ans = Math.max(ans, dim);
    }
}