import java.io.*;
import java.util.*;

class Main {
    private static int N;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static int[][] map, dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        map = new int[N+2][N+2];
        dp = new int[N+2][N+2];

        StringTokenizer st;
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++) {
                ans = Math.max(ans, dfs(i, j));
            }
        }

        System.out.println(ans);
    }

    private static int dfs(int x, int y){
        if(dp[x][y] > 0) return dp[x][y];

        int max = 0;
        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(map[nx][ny] > map[x][y]) {
                max = Math.max(max, dfs(nx, ny));
            }
        }

        return dp[x][y] = max + 1;
    }
}