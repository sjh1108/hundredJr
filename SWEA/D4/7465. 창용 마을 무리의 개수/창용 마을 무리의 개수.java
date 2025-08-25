import java.util.*;

public class Solution {
    private static int N, M;

    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> graph;

    private static int unionFind(){
        int cnt = 0;

        for(int i = 1; i <= N; i++){
            if(!visited[i]){
                cnt++;
                bfs(i);
            }
        }

        return cnt;
    }

    private static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        
        visited[start] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int i: graph.get(cur)){
                if(visited[i]) continue;

                visited[i] = true;
                q.add(i);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 1; t <= T; t++){
            N = sc.nextInt();
            M = sc.nextInt();

            visited = new boolean[N+1];
            graph = new ArrayList<>();

            for(int i = 0; i <= N; i++){
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < M; i++){
                int from = sc.nextInt();
                int to = sc.nextInt();

                graph.get(from).add(to);
                graph.get(to).add(from);
            }

            System.out.println("#" + t + " " + unionFind());
        }

        sc.close();
    }
}
