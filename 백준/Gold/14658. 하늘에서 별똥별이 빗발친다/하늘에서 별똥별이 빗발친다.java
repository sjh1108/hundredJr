import java.io.*;
import java.util.*;

class Main {
    private static int L;

    private static List<int[]> list;

    private static int max(int r, int c){
        int cnt = 0;

        for(int[] s: list){
            int x = s[0];
            int y = s[1];

            if(x >= r && x <= r+L && y >= c && y <= c+L){
                cnt++;
            }
        }

        return cnt;
    }

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

        st.nextToken(); st.nextToken();
		L = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new int[]{a, b});
        }

        int max = 0;
        for(int[] a : list){
            for(int[] b: list){
                int x = a[0];
                int y = b[1];

                max = Math.max(max, max(x, y));
            }
        }

        System.out.println(K - max);
	}

}
