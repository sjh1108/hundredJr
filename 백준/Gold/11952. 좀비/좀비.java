import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    private static final long INF = 1L << 60;
    private static final int SHIFT = 17;
    private static final long MASK = (1L << SHIFT) - 1;

    private static int N, M, K, S;
    private static int p, q;

    private static boolean[] infested;
    private static boolean[] dangerCities;

    private static int[] head;
    private static int[] to;
    private static int[] nextEdge;
    private static int edgeCount;

    private static int[] danger;
    private static int dangerFront, dangerBack;
    private static int[] distFromZombie;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        infested = new boolean[N + 1];
        for (int i = 0; i < K; i++) infested[Integer.parseInt(br.readLine())] = true;

        head = new int[N + 1];
        Arrays.fill(head, -1);
        to = new int[M * 2];
        nextEdge = new int[M * 2];
        edgeCount = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            addEdge(a, b);
            addEdge(b, a);
        }

        checkDangerCites();
        System.out.println(dijkstra());
    }

    private static void addEdge(int a, int b) {
        to[edgeCount] = b;
        nextEdge[edgeCount] = head[a];
        head[a] = edgeCount++;
    }

    // check danger with bfs
    private static void checkDangerCites() {
        dangerCities = new boolean[N + 1];
        distFromZombie = new int[N + 1];
        Arrays.fill(distFromZombie, -1);

        danger = new int[N + 5];
        dangerFront = 0;
        dangerBack = 0;

        for (int city = 1; city <= N; city++) {
            if (!infested[city]) continue;
            distFromZombie[city] = 0;
            danger[dangerBack++] = city;
        }

        getDangerCites();
    }

    // get danger cities
    private static void getDangerCites() {
        while (dangerFront < dangerBack) {
            int cur = danger[dangerFront++];
            if (distFromZombie[cur] == S) continue;

            int nd = distFromZombie[cur] + 1;
            for (int e = head[cur]; e != -1; e = nextEdge[e]) {
                int near = to[e];
                if (distFromZombie[near] != -1) continue;

                distFromZombie[near] = nd;
                danger[dangerBack++] = near;
                if (!infested[near]) dangerCities[near] = true;
            }
        }
    }

    private static long dijkstra() {
        long[] cost = new long[N + 1];
        Arrays.fill(cost, INF);
        cost[1] = 0;

        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(pack(0, 1));

        while (!pq.isEmpty()) {
            long state = pq.poll();
            int t = (int) (state & MASK);
            long c = state >>> SHIFT;

            if (c != cost[t]) continue;
            if (t == N) return c;

            for (int e = head[t]; e != -1; e = nextEdge[e]) {
                int next = to[e];
                if (infested[next]) continue;

                long add = (next == N) ? 0 : (dangerCities[next] ? q : p);
                long nCst = c + add;
                if (nCst < cost[next]) {
                    cost[next] = nCst;
                    pq.add(pack(nCst, next));
                }
            }
        }

        return cost[N];
    }

    private static long pack(long c, int city) {
        return (c << SHIFT) | city;
    }
}
