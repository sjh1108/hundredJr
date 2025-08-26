import java.util.*;
import java.awt.Point;

class Solution {
	private static int N;
	private static double E;

	private static int[] parents;

	private static Point[] land;
	private static List<Edge> list;

	static class Edge implements Comparable<Edge>{
		int from, to;
		long cost;

		public Edge(int from, int to, long cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge e){
			return Long.compare(this.cost, e.cost);
		}
	}

	private static boolean union(int a, int b){
		int rootA = find(a);
		int rootB = find(b);

		if(rootA == rootB) return false;
		parents[rootB] = rootA;
		return true;
	}

	private static int find(int x){
		if(x == parents[x]) return x;
		return parents[x] = find(parents[x]);
	}

	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int t = 1; t <= T; t++){
			N = sc.nextInt();

			land = new Point[N];
			parents = new int[N];
			int[] tmp = new int[N];
			for(int i = 0; i < N; i++){
				tmp[i] = sc.nextInt();
			}
			for(int i = 0; i < N; i++){
				land[i] = new Point(tmp[i], sc.nextInt());
				parents[i] = i;
			}
			E = sc.nextDouble();

			list = new ArrayList<>();
			for(int i = 0; i < N; i++){
				for(int j = i+1; j < N; j++){
					long dx = Math.abs(land[i].x - land[j].x);
					long dy = Math.abs(land[i].y - land[j].y);

					list.add(new Edge(i, j, dx*dx + dy*dy));
				}
			}

			list.sort(null);

			int cnt = 0;
			long res = 0L;
			for(Edge edge: list){
				if(union(edge.from, edge.to)){
					res += edge.cost;

					if(++cnt == N-1) break;
				}
			}

			System.out.println("#" + t + " " + Math.round(res * E));
		}
		sc.close();
	}
}