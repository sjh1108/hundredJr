import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken());
        
		Set<Integer> set = new HashSet<>();
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			set.add(arr[i]);
		}
		int ans = 1;
		for(int k: set) {
			//System.out.println(k);
			int cnt=1;
			int pre=arr[0];
			for(int i=1; i<N; i++) {
				if(arr[i]==k) continue;	
				if(pre!=arr[i]) {
					cnt=1;
				}else {
					cnt++;
					ans = Math.max(ans, cnt);
				}
				pre = arr[i];
			}
		}
		System.out.println(ans);
	}
}
