import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());
        int[][] map = new int[N][N];
        int[][] dp = new int[N][N];
        long[] cells = new long[N * N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                cells[i * N + j] = ((long) map[i][j] << 32) | (i * N + j);
            }
        }

        Arrays.sort(cells);

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int ans = 0;
        for (int k = N * N - 1; k >= 0; k--) {
            int idx = (int) (cells[k] & 0xFFFFFFFFL);
            int x = idx / N, y = idx % N;

            dp[x][y] = 1;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] > map[x][y]) {
                    dp[x][y] = Math.max(dp[x][y], dp[nx][ny] + 1);
                }
            }
            ans = Math.max(ans, dp[x][y]);
        }

        System.out.println(ans);
    }
}