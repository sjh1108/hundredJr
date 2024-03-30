import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    static int[][] arr, max, min;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        arr = new int[N][3];
        max = new int[N+1][3];
        min = new int[N+1][3];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++){
            max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + arr[i-1][0];
            max[i][1] = Math.max(Math.max(max[i-1][0], max[i-1][1]), max[i-1][2]) + arr[i-1][1];
            max[i][2] = Math.max(max[i-1][1], max[i-1][2]) + arr[i-1][2];

            min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + arr[i-1][0];
            min[i][1] = Math.min(Math.min(min[i-1][0], min[i-1][1]), min[i-1][2]) + arr[i-1][1];
            min[i][2] = Math.min(min[i-1][1], min[i-1][2]) + arr[i-1][2];
        }

        sb.append(Math.max(Math.max(max[N][0], max[N][1]), max[N][2]) + " " + Math.min(Math.min(min[N][0], min[N][1]), min[N][2]));
        System.out.println(sb);
    }
}