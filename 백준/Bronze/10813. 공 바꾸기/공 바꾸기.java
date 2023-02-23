import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int arr[] = new int[N + 1];
        for(int i = 1; i <= N; i++){
            arr[i] = i;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int tmp = arr[start];
            arr[start] = arr[end];
            arr[end] = tmp;
        }

        for(int i = 1; i <= N; i++){
            sb.append(arr[i]).append(' ');
        }

        System.out.println(sb);
    }
}