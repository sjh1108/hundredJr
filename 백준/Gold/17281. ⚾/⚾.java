import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int point;
	
	private static int[] lineUp;
	private static boolean[] visited;
	
	private static int[][] player;
	
	private static void play(int inning, int score, int start) {
		if(inning == N) {
//			System.out.println(score);
			point = Math.max(point, score);
			return;
		}
		 
		int outCount = 0;
		boolean[] bat = new boolean[3];
		while(outCount < 3) {
			int temp = player[inning][lineUp[start]];
			
			switch (temp) {
			case 0:
				outCount++;
				break;
				
			case 1:
				if(bat[2]) score += 1;
				for(int i = 2; i > 0; i--) {
					bat[i] = bat[i-1];
				}
				bat[0] = true;
				break;
				
			case 2:
				if(bat[2]) score += 1;
				if(bat[1]) score += 1;
				
				bat[2] = bat[0];
				bat[1] = true;
				bat[0] = false;
				
				break;
				
			case 3:
				for(int i = 0; i < 3; i++) {
					if(bat[i]) ++score;
					bat[i] = false;
				}
				
				bat[2] = true;
				
				break;
			case 4:
				for(int i = 0; i < 3; i++) {
					if(bat[i]) ++score;
					bat[i] = false;
				}
				++score;
				break;
			}
			
			start = (start + 1) % 9; 
		}

		play(inning+1, score, start);
	}
	
	private static void printPlayer() {
		for(int i: lineUp) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	private static void dfs(int depth) {
		if(depth == 9) {
//			printPlayer();
			play(0, 0, 0);
			return;
		}
		
		if(depth == 3) {
			dfs(depth+1);
			return;
		} else {
			for(int i = 1; i < 9; i++) {
				if(visited[i]) continue;
				
				lineUp[depth] = i;
				visited[i] = true;
				
				dfs(depth+1);
				
				lineUp[depth] = 0;
				visited[i] = false;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		lineUp = new int[9];
		visited = new boolean[9];
		
		player = new int[N][9];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 9; j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		lineUp[3] = 0;
		visited[0] = true;
		
		dfs(0);
		
		System.out.println(point);
	}
}
