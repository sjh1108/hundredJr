import java.io.*;
import java.util.*;

class Main {
	private static char[] w1, w2, w3;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		int T = 0;
		while(T++ < n) {
            StringTokenizer st = new StringTokenizer(br.readLine());
			w1 = st.nextToken().toCharArray();
			w2 = st.nextToken().toCharArray();
			w3 = st.nextToken().toCharArray();

			if(bfs())   sb.append("Data set " + T + ": yes\n");
            else        sb.append("Data set " + T + ": no \n");
		}
		System.out.println(sb);
	}
	
	private static boolean bfs() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] check = new boolean[201][201];
		
		q.add(new int[] {0,0,0});
		check[0][0] = true;
		
		while(!q.isEmpty()) {
            int[] cur = q.poll();
			int fir = cur[0];
			int sec = cur[1];
			int thr = cur[2];
			
			if(thr == w3.length) {
				return true;
			}
			
			if(fir < w1.length && !check[fir + 1][sec]
				&& w1[fir] == w3[thr]) {

				q.add(new int[] {fir + 1, sec, thr + 1});
				check[fir + 1][sec] = true;
			}
			
			if(sec<w2.length && !check[fir][sec + 1]
				&& w2[sec] == w3[thr]) {

				q.add(new int[] {fir, sec + 1, thr + 1});
				check[fir][sec + 1] = true;
			}
		}

		return false;
	}
}