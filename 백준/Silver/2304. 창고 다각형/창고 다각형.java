import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] location = new int[1001];

        StringTokenizer st;
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            location[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        int max = 0;
		for(int l : location) {
			if(l > max) max = l;
			ans += max;
		}
		int max2 = 0;
		for(int i=1000; i>0; i--) {
			if(location[i] == max) break;
			if(location[i] > max2) max2 = location[i];
			ans -= max - max2;
		}

        System.out.println(ans);
    }
}