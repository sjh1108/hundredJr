import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        long[][] arr = new long[N+1][2];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Long.parseLong(st.nextToken());
            arr[i][1] = Long.parseLong(st.nextToken());
        }
        arr[N][0] = arr[0][0];
        arr[N][1] = arr[0][1];

        long sum = 0;
        for(int i = 0; i < N; i++){
            sum += arr[i][0]*arr[i+1][1] - arr[i+1][0]*arr[i][1];
        }

        sum = Math.abs(sum);
        System.out.printf("%.1f", sum/2.0);
    }
}
