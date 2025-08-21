import java.io.*;
import java.util.*;

public class Solution{
    private static int N, M;

    private static int cnt;

    private static boolean[][] visited;
    private static int[][] map;
    
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};
    private static boolean[][] tunnel = {
        {},
        {true, true, true, true},
        {true, false, true, false},
        {false, true, false, true},
        {true, true, false, false},
        {false, true, true, false},
        {false, false, true, true},
        {true, false, false, true}
    };

    private static boolean isIn(int x, int y){
        return (x >= 0 && x < N) && (y >= 0 && y < M);
    }
    private static void bfs(int r, int c, int time){
        Queue<int[]> q = new ArrayDeque<>();

        int[] cur = {r, c, 0};
        q.add(cur);
        visited[r][c] = true;

        cnt = 1;
        while(!q.isEmpty()){
            cur = q.poll();

            int x = cur[0];
            int y = cur[1];

            int tnl = map[x][y];
            
            for(int d = 0; d < 4; d++){
                if(!tunnel[tnl][d]) continue;
                
                int nx = x + dx[d];
                int ny = y + dy[d];
                
                // 맵 밖이거나
                // 터널이 아니거나
                // 방문했거나
                // 시간이 됐거나
                if(!isIn(nx, ny) 
                || map[nx][ny] == 0 
                || visited[nx][ny] 
                || cur[2]+1 == time) continue;

                // 연결이 되어있지 않거나
                int nTnl = map[nx][ny];
                if(tunnel[tnl][d] != tunnel[nTnl][(d + 2) % 4]) continue;
                
                visited[nx][ny] = true;
                cnt++;

                q.add(new int[]{nx, ny, cur[2] + 1});
            }
        }
    }
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int t = 1; t <= T; t++) {
            N = sc.nextInt();
            M = sc.nextInt();
            
            int x = sc.nextInt();
            int y = sc.nextInt();
            int time = sc.nextInt();
            visited = new boolean[N][M];
            map = new int[N][M];

            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    map[i][j] = sc.nextInt();
                }
            }

            bfs(x, y, time);
            boolean[][] tmp = visited;
            System.out.println("#" + t + " " + cnt);
		}
		
		sc.close();
	}
}
