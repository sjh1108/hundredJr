import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    
    static boolean[] visited;
    static int[] parent;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        
        visited = new boolean[N + 1];
        parent = new int[N + 1];
        for(int i = 0; i < N + 1; i++){
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        DFS(1);

        for(int i = 2; i < N + 1; i++) sb.append(parent[i]).append("\n");
        System.out.println(sb);
    }

    public static void DFS(int idx){
        visited[idx] = true;

        for(int i : list.get(idx)){
            if(!visited[i]){
                parent[i] = idx;
                DFS(i);
            }
        }
    }

}