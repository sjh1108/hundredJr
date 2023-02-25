import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;

    static int[] arr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        for(int i = 1; i <= N; i++){
            arr[i] = i;
        }
        M = Integer.parseInt(st.nextToken());

        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            while(start < end){
                int tmp = arr[start];
                arr[start] = arr[end];
                arr[end] = tmp;

                start++; end--;
            }
        }

        for(int i = 1; i <= N; i++){
            sb.append(arr[i]);
            sb.append(' ');
        }

        System.out.println(sb);
    }
}