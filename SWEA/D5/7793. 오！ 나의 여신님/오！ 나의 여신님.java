import java.io.*;
import java.util.*;

class Solution {
	private static int N, M;
	private static int min;

	private static char[][] map;
	private static boolean[][] visited;

	private static Queue<int[]> demon;
	private static Queue<int[]> locate;

	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static boolean isIn(int x, int y){
		return (x >= 0 && x < N) && (y >= 0 && y < M);
	}

	private static void bfs(){
		while(!locate.isEmpty()){
			// System.out.println("------------------");
			// for(int i = 0; i < N; i++){
			// 	for(int j = 0; j < M; j++){
			// 		System.out.print(map[i][j]);
			// 	}
			// 	System.out.println();
			// }
			// System.out.println();
			
			demonSpread();
			
			int locateSize = locate.size();
			while(locateSize-- > 0){
				int[] cur = locate.poll();
	
				int x = cur[0];
				int y = cur[1];
				int t = cur[2];
				
				for(int d = 0; d < 4; d++){
					int nx = x + dx[d];
					int ny = y + dy[d];
	
					if(!isIn(nx, ny)) continue;
					if(visited[nx][ny]) continue;

					if(map[nx][ny] == 'D'){
						min = t + 1;
						return;
					}
					
					if(map[nx][ny] == '*' || map[nx][ny] == 'X') continue;
	
	
					visited[nx][ny] = true;
					locate.add(new int[]{nx, ny, t+1});
				}
			}

		}
	}

	private static void demonSpread(){
		int size = demon.size();

		while(size-- > 0){
			int[] cur = demon.poll();

			int x = cur[0];
			int y = cur[1];

			for(int d = 0; d < 4; d++){
				int nx = x + dx[d];
				int ny = y + dy[d];

				if(!isIn(nx, ny)) continue;
				if(map[nx][ny] == '.' || map[nx][ny] == 'S'){
					map[nx][ny] = '*';
					demon.add(new int[]{nx, ny});
				}
            }
		}
	}


	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int t = 1; t <= T; t++){
			N = sc.nextInt();
			M = sc.nextInt();

			sc.nextLine();
			map = new char[N][M];
			visited = new boolean[N][M];
			demon = new ArrayDeque<>();
			locate = new ArrayDeque<>();
			for(int i = 0; i < N; i++){
				String str = sc.nextLine();
				for(int j = 0; j < M; j++){
					map[i][j] = str.charAt(j);

					if(map[i][j] == '*'){
						demon.add(new int[]{i, j});
					} else if(map[i][j] == 'S'){
						locate.add(new int[]{i, j, 0});
						visited[i][j] = true;
					}
				}
			}

			min = Integer.MAX_VALUE;
			bfs();

			System.out.println("#" + t + " " + (min == Integer.MAX_VALUE ? "GAME OVER" : min));
		}
		sc.close();
	}
}