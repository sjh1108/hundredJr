import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    static int[] arr;
    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static void BFS(){
        Queue<Integer> q = new LinkedList<>();
        q.add(K);

        int cnt = 1;
        while(!q.isEmpty()){
            int cur = q.poll();
            visited[cur] = true;
            arr[cur] = cnt++;

            Collections.sort(graph.get(cur), Collections.reverseOrder());

            for(int i: graph.get(cur)){
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
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

        BFS();
        for(int i = 1; i <= N; i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }
}