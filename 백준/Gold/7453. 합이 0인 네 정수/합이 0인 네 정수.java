import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static long[] ab, cd;
    static long[] a, b, c, d;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());


        a = new long[N]; b = new long[N];
        c = new long[N]; d = new long[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            a[i] = Long.parseLong(st.nextToken());
            b[i] = Long.parseLong(st.nextToken());

            c[i] = Long.parseLong(st.nextToken());
            d[i] = Long.parseLong(st.nextToken());
        }

        ab = new long[N*N];
        cd = new long[N*N];
        
        int idx = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                ab[idx] = a[i] + b[j];
                cd[idx++] = c[i] + d[j];
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);

        long answer = 0;
		int left = 0, right = N*N-1;
		while (left < N*N && right >= 0) {
            long sum = ab[left] + cd[right];
			if (sum < 0)
				left++;

            else if (sum > 0)
				right--;

            else {
				long cnt1 = 1, cnt2 = 1;

				while (left + 1 < N*N && (ab[left] == ab[left+1])) {
					cnt1++;
					left++;
				}

				while (right > 0 && (cd[right] == cd[right-1])) {
					cnt2++;
					right--;
				}
                
				answer += cnt1 * cnt2;
				left++;
			}
		}

        System.out.println(answer);
    }
}