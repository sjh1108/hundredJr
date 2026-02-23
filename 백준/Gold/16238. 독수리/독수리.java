import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        long ans = 0;
        long prefix = 0;
        for (int m = 1; m <= N; m++) {
            prefix += arr[m - 1];
            long penalty = (long) m * (m - 1) / 2;
            long total = prefix - penalty;
            if (total > ans) ans = total;
        }

        System.out.println(ans);
    }
}
