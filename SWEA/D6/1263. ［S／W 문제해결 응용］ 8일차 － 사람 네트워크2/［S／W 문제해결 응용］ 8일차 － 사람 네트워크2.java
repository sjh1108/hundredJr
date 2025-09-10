import java.util.*;

class Solution {
	private static int N;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; ++t <= T;) {
			N = sc.nextInt();

			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++){
				for(int j = 0; j < N; j++){
					map[i][j] = sc.nextInt() == 1 ? 1 : 1_000_000;
					if(i == j) map[i][j] = 0;
				}
			}

			for(int k = 0; k < N; k++){
				for(int i = 0; i < N; i++){
					if(i == k) continue;
					for(int j = 0; j < N; j++){
						if(i == j || j == k) continue;
						
						map[i][j] = Math.min(map[i][k]+map[k][j], map[i][j]);
					}
				}
			}

			int min = Integer.MAX_VALUE;
			for(int i = 0; i < N; i++){
				int sum = 0;
				for(int j = 0; j < N; j++){
					sum += map[i][j];
				}

				min = Math.min(min, sum);
			}

			System.out.println("#" + t + " " + min);
		}

		sc.close();
	}
}