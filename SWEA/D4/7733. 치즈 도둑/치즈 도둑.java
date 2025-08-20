import java.io.*;
import java.util.*;

public class Solution{
    private static int N;

    private static int max;

    private static boolean[][] visited;
    private static int[][] map;
    
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static boolean isIn(int x, int y){
        return (x >= 0 && x < N) && (y >= 0 && y < N);
    }
    private static void bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();

        visited[x][y] = true;
        q.offer(new int[]{x, y});
        while(!q.isEmpty()){
            int[] cur = q.poll();

            int curX = cur[0];
            int curY = cur[1];
            for(int d = 0; d < 4; d++){
                int nx = curX + dx[d];
                int ny = curY + dy[d];

                if(!isIn(nx, ny) || visited[nx][ny]) continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
    private static void eat(int day){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] == day){
                    map[i][j] = 0;
                    visited[i][j] = true;
                } else if(map[i][j] > day){
                    visited[i][j] = false;
                } else{
                    visited[i][j] = true;
                }
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(visited[i][j] || map[i][j] == 0) continue;

                cnt++;

                bfs(i, j);
            }
        }
        max = Math.max(cnt, max);
    }
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            
            visited = new boolean[N][N];
            map = new int[N][N];

            int maxTaste = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    map[i][j] = sc.nextInt();

                    maxTaste = Math.max(maxTaste, map[i][j]);
                }
            }

            max = 1;
            for(int i = 1; i < maxTaste; i++){
                eat(i);
            }

            System.out.println("#" + t + " " + max);
		}
		
		sc.close();
	}
}
