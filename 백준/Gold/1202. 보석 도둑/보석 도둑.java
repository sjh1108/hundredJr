import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

	static class jewel implements Comparable<jewel>{
		int mass, value;

		jewel(int mass, int value){
			this.mass = mass;
			this.value = value;
		}

		@Override
		public int compareTo(jewel o){
			if(this.mass == o.mass)
				return o.value - this.value;
			return this.mass - o.mass;
		}
	}
	static int[] bag;
	static jewel[] jewel;
	static long answer = 0;

    public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		jewel = new jewel[N];
		for(int i = 0; i < N; i++){
			st = new StringTokenizer(br.readLine());
			int mass = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());
			jewel[i] = new jewel(mass, value);
		}
		Arrays.sort(jewel);

		bag = new int[M];
		for(int i = 0; i < M; i++){
			bag[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(bag);

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0, j = 0; i < M; i++){
			while(j < N && jewel[j].mass <= bag[i]){
				pq.add(jewel[j++].value);
			}

			if(!pq.isEmpty())
				answer += pq.poll();
		}
		
		System.out.println(answer);
	}
}