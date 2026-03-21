import java.io.*;

class Main {
    static int N;
    static int[][] map, dp;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));

        in.nextToken(); N = (int) in.nval;

        map = new int[N + 2][N + 2];
        dp = new int[N + 2][N + 2];

        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++) {
                in.nextToken();
                map[i][j] = (int) in.nval;
            }

        int ans = 0;
        for (int i = 1; i <= N; i++)
            for (int j = 1; j <= N; j++)
                ans = Math.max(ans, dfs(i, j));

        System.out.println(ans);
    }

    static int dfs(int x, int y) {
        if (dp[x][y] > 0) return dp[x][y];

        dp[x][y] = 1;
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d], ny = y + dy[d];
            if (map[nx][ny] > map[x][y])
                dp[x][y] = Math.max(dp[x][y], dfs(nx, ny) + 1);
        }
        return dp[x][y];
    }
}
