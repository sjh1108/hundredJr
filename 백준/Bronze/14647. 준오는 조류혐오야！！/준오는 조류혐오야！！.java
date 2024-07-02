import java.io.*;
import java.util.*;
 
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    
    static int N, M;
	public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int cnt = 0;
        int max = 0;
		int[] arr = new int[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
            int maxj = 0;
			for (int j = 0; j < M; j++) {
                int tmp = 0;
                String token = st.nextToken();
                for(int t = 0; t < token.length(); t++){
                    if(token.charAt(t) == '9') tmp++;
                }
                
                arr[j] += tmp;
                cnt += tmp;
                maxj += tmp;
			}
            
            max = Math.max(max, maxj);
		}
        
        for(int i = 0; i < M; i++){
            max = Math.max(max, arr[i]);
        }
        
        System.out.println(cnt - max);
	}
}