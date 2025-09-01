import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	
	private static int[] parent;
	
	private static void init() {
		for(int i = 0; i < N; i++) {
			parent[i] = i;
		}
	}
	
	private static void union(int a, int b) {
        a = find(a);
        b = find(b);
		
        parent[b] = a;
	}
	
	private static int find(int p) {
		if(parent[p] == p) return p;
		
		return parent[p] = find(parent[p]);
	}
	
	public static void main(String[] args) throws IOException{
//		System.setIn(new FileInputStream("Test3.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parent = new int[N];
		init();
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(find(a) != find(b)){
                union(a, b);
            } else {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(0);
	}

}
