import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    public static void main(String[] args) throws IOException{
		N = Integer.parseInt(br.readLine());
		HashMap<Integer, Integer> mapA;
		HashMap<Integer, Integer> mapB;
		while(N-- > 0){
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());

			mapA = new HashMap<>();
			mapB = new HashMap<>();
			for(int i = 1; i <= 4; i++){
				mapA.put(i, 0);
				mapB.put(i, 0);
			}
			for(int i = 0; i < A; i++){
				int a = Integer.parseInt(st.nextToken());
				mapA.put(a, mapA.get(a)+1);
			}

			st = new StringTokenizer(br.readLine());
			int B = Integer.parseInt(st.nextToken());

			for(int i = 0; i < B; i++){
				int b = Integer.parseInt(st.nextToken());
				mapB.put(b, mapB.get(b)+1);
			}

			for(int i = 4; i > 0; i--){
				int a = mapA.get(i);
				int b = mapB.get(i);

				if(a > b) {
					sb.append('A').append('\n');
					break;
				}
				else if(a < b) {
					sb.append('B').append('\n');
					break;
				}
				else if(i == 1) sb.append('D').append('\n');
			}
		}
		System.out.println(sb.toString());
	}
}