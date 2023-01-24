import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int max;
    
    static int[] f;
    static int[] arr;

    static Integer[][] dp;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++){
            arr[i] = Integer.parseInt(st.nextToken()) + arr[i - 1];
        }


        for(int i = 0; i < K; i++){
            M = 0;
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(func(a, b));
            sb.append('\n');
        }

        System.out.println(sb);
    }

    static int func(int i, int j){
        return arr[j] - arr[i - 1];
    }
}