import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[][] map;
	
	private static int cntA, cntB;
	private static boolean check(int x, int y, int size) {
		int init = map[x][y];
		
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(init != map[i][j]) return false;
			}
		}
		
		return true;
	}
	private static void solve(int x, int y, int size) {
		if(check(x, y, size)) {
			if(map[x][y] == 0) {
				cntA++;
			} else {
				cntB++;
			}
			
			return;
		}

		size /= 2;
		
		solve(x, y, size);
		solve(x + size, y, size);
		solve(x, y + size, size);
		solve(x + size, y + size, size);
	}
	public static void main(String[] args) throws IOException{
//		System.setIn(new FileInputStream("Test2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// input
		cntA = 0; cntB = 0;
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {				
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// divide & conquer
		solve(0, 0, N);
		
		// output
		System.out.println(cntA);
		System.out.println(cntB);
	}

}
