import java.io.*;
import java.util.*;

class Main {
    private static final int NEG_INF = Integer.MIN_VALUE;
    private static final int POS_INF = Integer.MAX_VALUE;

    private static int N, B, K;
    private static int size;

    private static int[][] maxTree;
    private static int[][] minTree;

    private static int queryMax;
    private static int queryMin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < N; c++) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        initTree();
        build(map);

        StringBuilder sb = new StringBuilder();
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            int r2 = r + B - 1;
            int c2 = c + B - 1;

            sb.append(queryDiff(r, c, r2, c2)).append('\n');
        }

        System.out.print(sb);
    }

    private static void initTree() {
        size = 1;
        while (size < N) {
            size <<= 1;
        }

        int treeSize = size << 1;
        maxTree = new int[treeSize][treeSize];
        minTree = new int[treeSize][treeSize];

        for (int i = 0; i < treeSize; i++) {
            Arrays.fill(maxTree[i], NEG_INF);
            Arrays.fill(minTree[i], POS_INF);
        }
    }

    private static void build(int[][] map) {
        int treeSize = size << 1;

        for (int r = 0; r < N; r++) {
            int x = r + size;
            for (int c = 0; c < N; c++) {
                int y = c + size;
                maxTree[x][y] = map[r][c];
                minTree[x][y] = map[r][c];
            }
        }

        for (int x = size; x < treeSize; x++) {
            for (int y = size - 1; y > 0; y--) {
                maxTree[x][y] = Math.max(maxTree[x][y << 1], maxTree[x][(y << 1) | 1]);
                minTree[x][y] = Math.min(minTree[x][y << 1], minTree[x][(y << 1) | 1]);
            }
        }

        for (int x = size - 1; x > 0; x--) {
            for (int y = 1; y < treeSize; y++) {
                maxTree[x][y] = Math.max(maxTree[x << 1][y], maxTree[(x << 1) | 1][y]);
                minTree[x][y] = Math.min(minTree[x << 1][y], minTree[(x << 1) | 1][y]);
            }
        }
    }

    private static int queryDiff(int r1, int c1, int r2, int c2) {
        queryMax = NEG_INF;
        queryMin = POS_INF;

        int left = r1 + size;
        int right = r2 + size;

        while (left <= right) {
            if ((left & 1) == 1) {
                accumulateY(left++, c1, c2);
            }
            if ((right & 1) == 0) {
                accumulateY(right--, c1, c2);
            }
            left >>= 1;
            right >>= 1;
        }

        return queryMax - queryMin;
    }

    private static void accumulateY(int xNode, int c1, int c2) {
        int left = c1 + size;
        int right = c2 + size;

        while (left <= right) {
            if ((left & 1) == 1) {
                queryMax = Math.max(queryMax, maxTree[xNode][left]);
                queryMin = Math.min(queryMin, minTree[xNode][left]);
                left++;
            }
            if ((right & 1) == 0) {
                queryMax = Math.max(queryMax, maxTree[xNode][right]);
                queryMin = Math.min(queryMin, minTree[xNode][right]);
                right--;
            }
            left >>= 1;
            right >>= 1;
        }
    }
}