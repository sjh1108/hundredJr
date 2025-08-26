import java.util.*;

class Solution {
	private static int V, E;

	private static int[] parents;

	private static Queue<Edge> pq;

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
			V = sc.nextInt();
			E = sc.nextInt();
			
			parents = new int[V+1];
			for(int i = 1; i < V+1; i++){
				parents[i] = i;
			}
			pq = new PriorityQueue<>();
			for(int i = 0; i < E; i++){
				Edge e = new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt());
				pq.add(e);
			}

			int cnt = 0;
			long res = 0L;
			while(!pq.isEmpty() && cnt < V){
				Edge cur = pq.poll();

				if(union(cur.from, cur.to)){
					res += cur.cost;

					if(++cnt == V) break;
				}
			}

			System.out.println("#" + t + " " + res);
		}
		sc.close();
	}
}