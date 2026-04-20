import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    static boolean[] visited;
    static int[] distance;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        distance = new int[n + 1];
        visited = new boolean[n + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 0; i < n + 1; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(graph, start);
        for(int i = 1; i < n + 1; i++){
            sb.append(distance[i] + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(ArrayList<ArrayList<Integer>> graph, int start) {
        visited[start] = true;
        distance[start] = count++;

        for(int i = 0; i < graph.get(start).size(); i++) {
            int next = graph.get(start).get(i);

            if(!visited[next]) {
                dfs(graph, next);
            }
        }
    }
}
