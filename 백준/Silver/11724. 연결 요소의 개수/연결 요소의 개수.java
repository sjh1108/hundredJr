import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;

    static int[] arr;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        int answer = 0;
        for(int i = 1; i <= N; i++){
            if(dfs(i)){
                answer++;
            }
        }

        System.out.println(answer);
    }

    static boolean dfs(int x){
        if(visited[x]){
            return false;
        } else{
            visited[x] = true;

            int size = graph.get(x).size();
            for(int i = 0; i < size; i++){
                int value = graph.get(x).get(i);
                if(!visited[value]){
                    dfs(value);
                }
            }

            return true;
        }
    }
}