import java.io.*;
import java.util.*;

class Main {
    private static long INF = 1L << 60;
    
    private static int N, M, K, S;
    private static int p, q;

    private static Set<Integer> infested, dangerCities;
    private static List<List<Integer>> roadList;

    private static Queue<Integer> danger;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken()); S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken()); q = Integer.parseInt(st.nextToken());

        infested = new HashSet<>();
        for(int i = 0; i < K; i++) infested.add(Integer.parseInt(br.readLine()));

        roadList = new ArrayList<>();
        for(int i = 0; i <= N; i++) roadList.add(new ArrayList<>());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            roadList.get(a).add(b);
            roadList.get(b).add(a);
        }

        checkDangerCites();
        System.out.println(dijkstra());
    }

    // check danger with bfs
    private static void checkDangerCites(){
        danger = new ArrayDeque<>(infested);
        getDangerCites();
    }
    
    // get danger cities
    private static void getDangerCites(){
        dangerCities = new HashSet<>();
        boolean[] visited = new boolean[N + 1];
        for(int city : infested) visited[city] = true;

        for(int s = 0; s < S; s++){
            int size = danger.size();

            for(int i = 0; i < size; i++){
                int cur = danger.poll();

                for(int near: roadList.get(cur)){
                    if(visited[near]) continue;

                    visited[near] = true;
                    danger.add(near);
                    if(!infested.contains(near)) dangerCities.add(near);
                }
            }
        }
    }

    private static long dijkstra(){
        long[] cost = new long[N+1];
        Arrays.fill(cost, INF);
        cost[1] = 0;

        Queue<long[]> pq = new PriorityQueue<>((o1, o2) -> Long.compare(o1[1], o2[1]));
        pq.add(new long[]{1, 0});

        while(!pq.isEmpty()){
            long[] cur = pq.poll();

            int t = (int)cur[0];
            long c = cur[1];
            
            if(c > cost[t]) continue;
            if(t == N) return c;

            for(int next: roadList.get(t)){
                if(infested.contains(next)) continue;

                long add = (next == N) ? 0 : (dangerCities.contains(next) ? q : p);
                long nCst = c + add;
                if(nCst < cost[next]){
                    cost[next] = nCst;
                    pq.add(new long[]{next, nCst});
                }
            }
        }

        return cost[N];
    }
}
