import java.io.*;
import java.util.*;

class Main {
    static class Point{
        int x, y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        List<Point> list;
        List<List<Integer>> graph;

        StringBuilder sb = new StringBuilder();

        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());

            list = new ArrayList<>();
            graph = new ArrayList<>();
            
            for(int i = 0; i < N+2; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                list.add(new Point(x, y));
            }

            for(int i = 0; i < N+2; i++){
                graph.add(new ArrayList<>());
            }

            for(int i = 0; i < N+1; i++){
                for(int j = i+1; j < N+2; j++){
                    if(mahattan(list.get(i), list.get(j)) <= 1000){
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            sb.append(bfs(graph, N) ? "happy" : "sad");
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static int mahattan(Point p1, Point p2){
        return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
    }

    private static boolean bfs(List<List<Integer>> graph, int N) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
 
        boolean[] visited = new boolean[N + 2];
        visited[0] = true;
 
        while (!q.isEmpty()) {
            int now = q.poll();
 
            if (now == N + 1) {
                return true;
            }
 
            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
 
        return false;
    }
}