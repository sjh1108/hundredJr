import java.io.*;
import java.util.*;

class Main {
	static class Pair {
		int x;
		int y;

		Pair(int a, int b) {
			x = a;
			y = b;
		}
	}

	private static int N, M;
    
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
    
	private static int[][] map, visit;
	private static Map<Integer, Integer> countMap;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visit = new int[N][M];
        
        countMap = new HashMap<>();

		for (int i = 0; i < N; ++i) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < M; ++j) {
				map[i][j] = input[j] - '0';
			}
		}

		int groupId = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (visit[i][j] == 0 && map[i][j] == 0) {
					groupId++;
					bfs(i, j, groupId);
				}
			}
		}

		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < M; ++j) {
				if (map[i][j] == 1) {
					int c = 1;
					Set<Integer> set = new HashSet<>();
					for (int d = 0; d < 4; ++d) {
						int nextX = i + dx[d];
						int nextY = j + dy[d];
						if (isInRange(nextX, nextY) && visit[nextX][nextY] != 0)
							set.add(visit[nextX][nextY]);
					}
					for (int key : set) {
						c += countMap.get(key);
					}
					sb.append(c%10);
				} else {
					sb.append("0");
				}
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}

	private static void bfs(int x, int y, int groupId) {
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(x, y));
		visit[x][y] = groupId;
		int count = 0;
		while (!q.isEmpty()) {
			Pair p = q.poll();
			count++;
			for (int i = 0; i < 4; ++i) {
				int nextX = p.x + dx[i];
				int nextY = p.y + dy[i];
				if (isInRange(nextX, nextY) && map[nextX][nextY] == 0 && visit[nextX][nextY] == 0) {
					visit[nextX][nextY] = groupId;
					q.add(new Pair(nextX, nextY));
				}
			}
		}
		countMap.put(groupId, count);
	}

	private static boolean isInRange(int nextX, int nextY) {
		if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M)
			return true;
		else
			return false;
	}
}