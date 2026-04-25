import java.io.*;
import java.util.*;

class Main {
    static class Edge implements Comparable<Edge>{
        int u, v, w;
        
        Edge(int u, int v, int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
        
        @Override
        public int compareTo(Edge e){
            return Integer.compare(this.w, e.w);
        }
    }

    private static int[] parent;
    private static Queue<Edge> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        pq = new PriorityQueue<>();
        
        int u, v, w;
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            u = Integer.parseInt(st.nextToken());
            v = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            pq.offer(new Edge(u, v, w));
        }

        System.out.println(kruskal(N));
    }

    private static int kruskal(int N) {
        Arrays.fill(parent, -1);
        int day = 0;

        while (!pq.isEmpty() && day < N - 1) {
            Edge e = pq.poll();

            if (!union(e.u, e.v)) continue;

            if (day + 1 < e.w) break;
            day++;
        }

        return day + 1;
    }

    private static boolean union(int u, int v) {
        int r1 = find(u);
        int r2 = find(v);

        if (r1 == r2) return false;

        if (parent[r1] < parent[r2]) {
            parent[r1] += parent[r2];
            parent[r2] = r1;
        } else {
            parent[r2] += parent[r1];
            parent[r1] = r2;
        }

        return true;
    }

    private static int find(int u) {
        if (parent[u] < 0) return u;

        return parent[u] = find(parent[u]);
    }
}