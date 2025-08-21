import java.io.*;
import java.util.*;

public class Solution{
    private static int N;

    private static int startX, startY;
    private static int max;
    private static int[][] map;
    private static boolean[] visited;

    private static int[] dx = {1, 1, -1, -1};
    private static int[] dy = {1, -1, -1, 1};

    private static boolean isIn(int x, int y){
        return (x >= 0 && x < N) && (y >= 0 && y < N);
    }

    private static void dfs(int x, int y, int d, int count){
        int nx = x + dx[d];
        int ny = y + dy[d];

        if (isIn(nx, ny)) {
            if (nx == startX && ny == startY && d == 3) {
                max = Math.max(max, count);
                return;
            }

            if (!visited[map[nx][ny]]) {
                visited[map[nx][ny]] = true;
                dfs(nx, ny, d, count + 1);
                visited[map[nx][ny]] = false;
            }
        }

        if (d < 3) {
            int ndir = d + 1;
            nx = x + dx[ndir];
            ny = y + dy[ndir];

            if (isIn(nx, ny)) {
                if (nx == startX && ny == startY && ndir == 3) {
                    max = Math.max(max, count);
                    return;
                }

                if (!visited[map[nx][ny]]) {
                    visited[map[nx][ny]] = true;
                    dfs(nx, ny, ndir, count + 1);
                    visited[map[nx][ny]] = false;
                }
            }
        }
    }
	public static void main(String args[]) throws Exception
	{
		// System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
            N = sc.nextInt();

            map = new int[N][N];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            max = -1;
            for(int i = 0; i < N - 2; i++){
                for(int j = 1; j < N-1; j++){
                    startX = i;
                    startY = j;
                    visited = new boolean[101];
                    visited[map[i][j]] = true;
                    dfs(i, j, 0,1);
                }
            }
            
            System.out.println("#" + t + " " + max);
		}
		
		sc.close();
	}
}
