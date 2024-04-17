import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

	static int V, E;
	static int[] parent;
	static class Node implements Comparable<Node>{
		int from, to, weight;

		Node(int from, int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o){
			return this.weight - o.weight;
		}
	}

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		parent = new int[V + 1];
		for(int i = 1; i < V + 1; i++){
			parent[i] = i;
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i = 0; i < E; i++){
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			pq.add(new Node(from, to, weight));
		}

		int size = pq.size();
		int total = 0;
		for(int i = 0; i < size; i++){
			Node node = pq.poll();

			int from = find(node.from);
			int to = find(node.to);

			if(!isSameParent(from, to)){
				total += node.weight;
				union(node.from, node.to);
			}
		}
		
		System.out.println(total);
    }

	static int find(int x){
		if(parent[x] == x) return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int x, int y){
		x = find(x);
		y = find(y);

		if(x != y) parent[y] = x;
	}

	static boolean isSameParent(int x, int y){
		x = find(x);
		y = find(y);

		if(x == y) return true;
		return false;
	}
}