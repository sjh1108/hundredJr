import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

	static final int INF = 1000000000;

    public static void main(String[] args) throws IOException{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		for(int i = 1; i <= N; i++){
			arr[i] = Integer.parseInt(st.nextToken()) + arr[i-1];
		}

		int ans = INF, sum = 0;
		int start = 0, end = 1;
		while(start <= N && end <= N){
			sum = arr[end] - arr[start];

			if(sum < M) end++;
			
			else{
				ans = Math.min(ans, end - start);
				start++;
			}
		}

		sb.append(ans == INF ? 0 : ans);
		System.out.println(sb);
	}
}