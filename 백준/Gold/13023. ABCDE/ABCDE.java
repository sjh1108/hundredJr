import java.io.*;
import java.util.*;

class Main {
    private static boolean[] friends;

    private static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        friends = new boolean[N];

        graph = new ArrayList<>();
        for(int i = 0; i < N; i++){
            graph.add(new ArrayList<>());
        }

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 0; i < N; i++){
            dfs(1, i);
        }

        System.out.println(0);
    }

    private static void dfs(int depth, int idx){
        if(depth == 5){
            System.out.println(1);
            System.exit(0);
        }

        friends[idx] = true;

        for(int nxt: graph.get(idx)){
            if(friends[nxt]) continue;

            dfs(depth+1, nxt);
        }

        friends[idx] = false;
    }
}