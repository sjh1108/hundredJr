import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    static final int MAX = Integer.MAX_VALUE;
    static int x;
    static ArrayList<ArrayList<Town>> list, reverseList;
    
    static class Town implements Comparable<Town>{
        int to;
        int cost;

        public Town(int to, int cost){
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Town o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        reverseList = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
            reverseList.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(from).add(new Town(to, cost));
            reverseList.get(to).add(new Town(from, cost));
        }

        int[] dist = Dijkstra(list);
        int[] reverseDist = Dijkstra(reverseList);
        
        int max = 0;
        for(int i = 1; i <= N; i++){
            max = Math.max(max, dist[i] + reverseDist[i]);
        }
        System.out.println(max);
    }

    static int[] Dijkstra(ArrayList<ArrayList<Town>> a){
        PriorityQueue<Town> pq = new PriorityQueue<>();
        pq.offer(new Town(x, 0));

        boolean[] visited = new boolean[N + 1];
        int[] dist = new int[N + 1];
        Arrays.fill(dist, MAX);
        dist[x] = 0;

        while(!pq.isEmpty()){
            Town curTown = pq.poll();
            int cur = curTown.to;

            if(!visited[cur]){
                visited[cur] = true;

                for(Town town : a.get(cur)){
                    if(!visited[town.to] && dist[town.to] > dist[cur] + town.cost){
                        dist[town.to] = dist[cur] + town.cost;
                        pq.offer(new Town(town.to, dist[town.to]));
                    }
                }
            }
        }

        return dist;
    }
}
