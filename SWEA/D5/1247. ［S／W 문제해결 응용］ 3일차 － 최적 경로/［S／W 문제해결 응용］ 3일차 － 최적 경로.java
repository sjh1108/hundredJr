import java.util.*;

class Solution {
	private static int N;
	private static int min;

	private static Point home, company;
	private static Point[] arr;
	static class Point{
		int x;
		int y;

		Point(int x, int y){
			this.x = x;
			this.y = y;
		}

		int getDist(Point p){
			return Math.abs(this.x - p.x) + Math.abs(this.y - p.y);
		}
	}

	private static void dfs(int cnt, Point prev, int sum, int flag){
		if(sum >= min) return;
		if(cnt == N){
			min = Math.min(min, sum + prev.getDist(home));
			return;
		}

		for(int i = 0; i < N; i++){
			if((flag & (1 << i)) != 0) continue;

			dfs(cnt + 1, arr[i], sum + prev.getDist(arr[i]), flag | 1 << i);
		}
	}
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int t = 1; t <= T; t++){
			N = sc.nextInt();

			home = new Point(sc.nextInt(), sc.nextInt());
			company = new Point(sc.nextInt(), sc.nextInt());
			arr = new Point[N];
			for(int i = 0; i < N; i++){
				arr[i] = new Point(sc.nextInt(), sc.nextInt());
			}

			min = Integer.MAX_VALUE;
			dfs(0, company, 0, 0);

			System.out.println("#" + t + " " + min);
		}
		sc.close();
	}
}