import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int left = 0;
        long sum = 0;
        for (int right = 0; right < N; right++) {
            sum += arr[right];
            while (sum >= S) {
                min = Math.min(min, right - left + 1);
                sum -= arr[left++];
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
