import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, K;
	private static int sx, sy;
	private static int ex, ey;
	
	private static int[][] map;
	// boolean[][] visited 대신, 방문 시간을 기록할 dist 배열 사용
	private static int[][] dist; 
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static boolean isIn(int x, int y) {
		return (x >= 0 && x < N) && (y >= 0 && y < M);
	}
	
	// 전역 변수 min 대신, 결과값을 직접 반환하도록 변경
	private static int bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		
		// 시작점 처리
		q.add(new int[] {sx, sy});
		dist[sx][sy] = 0; // 시작점의 시간은 0
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];
			
			// 현재 위치까지의 시간
			int currentTime = dist[x][y];

			// 목적지에 도착했다면 현재 시간 반환
			if (x == ex && y == ey) {
				return currentTime;
			}
			
			// 4가지 방향 탐색
			for(int d = 0; d < 4; d++) {
				// K칸 만큼 직진
				for(int l = 1; l <= K; l++) {
					int nx = x + dx[d] * l;
					int ny = y + dy[d] * l;
					
					// 1. 범위를 벗어나거나 벽을 만나면, 해당 방향으로 더 이상 갈 수 없으므로 break
					if(!isIn(nx, ny) || map[nx][ny] == 1) {
						break;
					}
					
					// --- 핵심 최적화 로직 ---
					// 2. 만약 다음 칸이 이미 방문되었는데,
					//    현재 경로보다 더 빠른 시간에 도달한 경로라면, 그 방향은 탐색할 필요가 없음 (break)
					if(dist[nx][ny] != -1 && dist[nx][ny] < currentTime + 1) {
						break;
					}
					
					// 3. 만약 다음 칸이 이미 방문되었고, 현재 경로와 같은 시간에 도달했다면,
					//    큐에 중복해서 넣을 필요는 없지만, 더 멀리 갈 수도 있으므로 탐색은 계속함 (continue)
					if(dist[nx][ny] != -1 && dist[nx][ny] == currentTime + 1) {
						continue;
					}

					// 4. 위 조건들에 걸리지 않은 새로운 칸을 발견한 경우
					dist[nx][ny] = currentTime + 1;
					q.add(new int[] {nx, ny});
				}
			}
		}
		
		// 큐가 비었는데 목적지에 도달하지 못한 경우
		return -1;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		dist = new int[N][M];
		for(int i = 0; i < N; i++) {
			// dist 배열을 -1 (미방문 상태)로 초기화
			Arrays.fill(dist[i], -1); 
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) == '.' ? 0 : 1;
			}
		}
		
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken())-1;
		sy = Integer.parseInt(st.nextToken())-1;
		ex = Integer.parseInt(st.nextToken())-1;
		ey = Integer.parseInt(st.nextToken())-1;
		
		// 사소한 오타 수정 (ex == ey -> sy == ey)
		if(sx == ex && sy == ey) {
			System.out.println(0);
			// System.exit(0) 대신 return 사용
			return; 
		}
		
		System.out.println(bfs());
	}
}