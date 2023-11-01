import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int x, y;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException{
        mapInput();
    
        System.out.println(DP(1, 1));
    }

    static void mapInput() throws IOException{
        st = new StringTokenizer(br.readLine());

        x = Integer.parseInt(st.nextToken()); y = Integer.parseInt(st.nextToken());
        map = new int[x + 1][y + 1];
        dp = new int[x + 1][y + 1];

        for(int i = 1; i <= x; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j <= y; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= x; i++) {
			for (int j = 1; j <= y; j++) {
				dp[i][j] = -1;
			}
		}
    }

    static int DP(int a, int b){
        if(a == x && b == y) return 1;
        if(dp[a][b] != -1) return dp[a][b];

        dp[a][b] = 0;
        for(int i = 0; i < 4; i++){
            int nx = a + dx[i], ny = b + dy[i];

            if(nx < 1 || ny < 1 || nx > x || ny > y) continue;

            if(map[a][b] > map[nx][ny]){
                dp[a][b] += DP(nx, ny);
            }
        }

        return dp[a][b];
    }
}