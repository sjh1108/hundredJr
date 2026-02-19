import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][] map = new long[N][4];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int idx = 0;
            map[i][idx++] = Long.parseLong(st.nextToken());
            map[i][idx++] = Long.parseLong(st.nextToken());
            map[i][idx++] = Long.parseLong(st.nextToken());
            map[i][idx++] = Long.parseLong(st.nextToken());
        }

        long[] ab = new long[N*N];
        long[] cd = new long[N*N];

        int idx = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                ab[idx] = map[i][0] + map[j][1];
                cd[idx++] = map[i][2] + map[j][3];
            }
        }

        Arrays.sort(ab);
        Arrays.sort(cd);

        long cnt = 0;
        int l = 0;
        int r = N*N - 1;
        while(l < N*N && r >= 0){
            long sum = ab[l] + cd[r];

            if(sum < 0){
                l++;
            } else if(sum > 0){
                r--;
            } else{
				long cnt1 = 1, cnt2 = 1;

				while (l + 1 < N*N && (ab[l] == ab[l+1])) {
					cnt1++;
					l++;
				}

				while (r > 0 && (cd[r] == cd[r-1])) {
					cnt2++;
					r--;
				}
                
				cnt += cnt1 * cnt2;
				l++;
            }
        }

        System.out.println(cnt);
    }
}