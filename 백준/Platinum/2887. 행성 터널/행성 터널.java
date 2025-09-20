import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N;

    private static int[] parent;
    private static Queue<Edge> edgeList;
    
    static class Edge implements Comparable<Edge>{
        int from, to, cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e){
            return Integer.compare(this.cost, e.cost);
        }
    }

    private static int find(int x){
        if(parent[x] == x) return x;

        return parent[x] = find(parent[x]);
    }
    private static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);
        if(rootX != rootY){
            parent[rootY] = rootX;
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        parent = new int[N];
        int[][] planets = new int[N][4];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            parent[i] = i;
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            planets[i][0] = i;
            planets[i][1] = x;
            planets[i][2] = y;
            planets[i][3] = z;
        }

        edgeList = new PriorityQueue<>();

        // x
        Arrays.sort(planets, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        int[] bef = planets[0];
        for(int i = 1; i < N; i++){
            int[] cur = planets[i];

            Edge nEdge = new Edge(bef[0], cur[0], Math.abs(bef[1] - cur[1]));
            edgeList.add(nEdge);

            bef = cur;
        }


        // y
        Arrays.sort(planets, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        bef = planets[0];
        for(int i = 1; i < N; i++){
            int[] cur = planets[i];

            Edge nEdge = new Edge(bef[0], cur[0], Math.abs(bef[2] - cur[2]));
            edgeList.add(nEdge);

            bef = cur;
        }

        // z
        Arrays.sort(planets, (o1, o2) -> Integer.compare(o1[3], o2[3]));
        
        bef = planets[0];
        for(int i = 1; i < N; i++){
            int[] cur = planets[i];

            Edge nEdge = new Edge(bef[0], cur[0], Math.abs(bef[3] - cur[3]));
            edgeList.add(nEdge);

            bef = cur;
        }

        int sum = 0;
        int cnt = 0;
        while(!edgeList.isEmpty()){
            Edge cur = edgeList.poll();

            if(find(cur.from) != find(cur.to)){
                union(cur.from, cur.to);

                sum += cur.cost;
                cnt++;

                if(cnt == N - 1){
                    break;
                }
            }
        }

        System.out.println(sum);
    }
}
