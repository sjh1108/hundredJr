import java.io.*;
import java.util.*;

class Main {
    private static final int INF = 1 << 30;
    private static int N, M, t;
    private static int s, g, h;

    private static int[] dist;
    private static List<List<int[]>> road;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            dist = new int[N+2];
            Arrays.fill(dist, INF);
            
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            road = new ArrayList<>();
            for(int i = 0; i < N + 2; i++) road.add(new ArrayList<>());

            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken()) * 2;

                if((a == g && b == h) || (a == h && b == g)) --d;

                road.get(a).add(new int[]{b, d});
                road.get(b).add(new int[]{a, d});
            }

            dijkstra();
            
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < t; i++){
                list.add(Integer.parseInt(br.readLine()));
            }

            Queue<Integer> ans = checkList(list);
            while(!ans.isEmpty()){
                sb.append(ans.poll() + " ");
            }
            sb.append('\n');
        } // testcase end
        
        System.out.print(sb);
    }

    private static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing(o -> o[1]));
        pq.add(new int[]{s, 0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            int to = cur[0];
            int cost = cur[1];

            if(dist[to] != INF) continue;
            dist[to] = cost;

            for(int[] nxt: road.get(to)){
                int next = nxt[0];
                int nxtCost = nxt[1] + cost;
                
                if(dist[next] == INF){
                    pq.add(new int[]{next, nxtCost});
                }
            }
        }
    }

    private static Queue<Integer> checkList(List<Integer> list){
        Queue<Integer> pq = new PriorityQueue<>();

        for(int p: list){
            if(dist[p]%2 == 1) pq.add(p);
        }

        return pq;
    }
}