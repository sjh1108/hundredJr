import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int max = 0;
        int[] arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(st.nextToken());

            arr[tmp] = arr[tmp-1] + 1;
            max = Math.max(arr[tmp], max);
        }

        System.out.println(N - max);
    }
}
