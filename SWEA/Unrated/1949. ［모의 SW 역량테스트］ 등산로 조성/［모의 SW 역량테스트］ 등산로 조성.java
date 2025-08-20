import java.io.FileInputStream;
import java.util.*;

public class Solution{
    private static int N, K;

    private static int max;

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static int[][] map;

    private static boolean[][] visited;

    private static boolean isIn(int x, int y){
        return (x >= 0 && x < N) && (y >= 0 && y < N);
    }
    private static void dfs(int x, int y, int depth, boolean flag){
        visited[x][y] = true;
        max = Math.max(max, depth);

        int value = map[x][y];

        for(int d = 0; d < 4; d++){
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(!isIn(nx, ny) || visited[nx][ny]) continue;

            if(map[nx][ny] < value){
                dfs(nx, ny, depth+1, flag);
            } else if(!flag && map[nx][ny] - value < K){
                int origin = map[nx][ny];
                map[nx][ny] = value - 1;
                
                dfs(nx, ny, depth+1, !flag);
                
                map[nx][ny] = origin;
            }
        }

        visited[x][y] = false;
    }
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            K = sc.nextInt();

            map = new int[N][N];

            int maxHeight = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    maxHeight = Math.max(maxHeight, map[i][j]);
                }
            }


            max = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(map[i][j] < maxHeight) continue;
                    visited = new boolean[N][N];
                    dfs(i, j, 1, false);
                }
            }

			System.out.println("#" + t + " " + max);
		}
		
		sc.close();
	}
}
