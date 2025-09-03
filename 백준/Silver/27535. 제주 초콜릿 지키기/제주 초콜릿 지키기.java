import java.io.BufferedReader;
//import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static long flag;

	private static Chocolate[] arr;
	private final static int[] idx = {2, 4, 0, 3, 1};
	private final static char[] charIdx = {'H', 'T', 'C', 'K', 'G'};

	static class Chocolate implements Comparable<Chocolate>{
		char c;
		int cnt;

		public Chocolate(char c, int cnt){
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Chocolate c){
			if(this.cnt == c.cnt){
				return Character.compare(this.c, c.c);
			}

			return Integer.compare(c.cnt, this.cnt);
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// H T C K G
		// C -> G -> H -> K -> T
		// 2 -> 4 -> 0 -> 3 -> 1
		arr = new Chocolate[5];
		for(int i = 0; i < 5; i++){
			arr[idx[i]] = new Chocolate(charIdx[i], Integer.parseInt(st.nextToken()));
		}
		
		long sum = 0;
		for(Chocolate c: arr){
			sum += c.cnt;
		}
		getFlag(sum);
		
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-->0){
			// input
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 5; i++){
				int n = Integer.parseInt(st.nextToken());
				arr[idx[i]].cnt -= n;

				sum -= n;
			}

			// output
			// if empty
			if(sum == 0){
				sb.append("07H\nNULL\n");
				continue;
			}
			// M1
			sb.append(Long.toString(sum, (int)flag));
			sb.append("7H");
			sb.append('\n');

			// M2
			List<Chocolate> list = getMaxList();
			for(Chocolate c: list){
				sb.append(c.c);
			}
			sb.append('\n');

			// getFlag
			getFlag(sum);
		}
		System.out.println(sb);
	}

	private static void getFlag(long sum){
		long f = sum%10;

		if(f == 0 || f == 1){
			flag = 10;
			return;
		}

		flag = f;
	}
	private static List<Chocolate> getMaxList(){
		List<Chocolate> list = new ArrayList<>();

		for(Chocolate c: arr){
			if(c.cnt == 0) continue;
			list.add(c);
		}

		Collections.sort(list);

		return list;
	}
}
