import java.io.*;
import java.util.*;

public class Main {
	static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws Exception{
		int n = Integer.parseInt(br.readLine());
		int[] count = new int[n + 1];
		int[][] arr = new int[1001][1001];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			for(int j = x1; j < (x1 + x2); j++) {
				for(int k = y1; k < (y1 + y2); k++) {
					arr[j][k] = i;
				}
			}
		}
		
		for(int i = 0; i < 1001; i++) {
			for(int j = 0; j < 1001; j++) {
				count[arr[i][j]]++;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			System.out.println(count[i]);
		}
	}
}