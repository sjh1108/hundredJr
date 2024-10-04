import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M, K;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int count = 1;
    static int[] order;
    static boolean[] visited;
    
    static void DFS(int before){
        ArrayList<Integer> list = graph.get(before);

        Collections.sort(list, Collections.reverseOrder());
        for(int next: list){
            if(visited[next]) continue;

            visited[next] = true;
            order[next] = count++;
            DFS(next);
        }
    }
    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        order = new int[N+1];
        visited = new boolean[N+1];
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        order[K] = count++;
        visited[K] = true;
        DFS(K);

        for(int i = 1; i < order.length; i++){
            sb.append(order[i]).append("\n");
        }

        System.out.println(sb);
    }
}