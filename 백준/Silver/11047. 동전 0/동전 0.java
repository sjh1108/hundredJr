import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M, K;
    static int max;
    static int min;
    
    static int[] arr;
    static int[] srr;

    static long[] f;
    static long[] lrr;

    static boolean[][] brr;

    static int[][] dp;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        K = 0;
        for(int i = N - 1; i >= 0; i--){
            if(arr[i] <= M){
                K += M / arr[i];
                M %= arr[i];
            }
            if(M == 0) break;
        }
        

        System.out.println(K);
    }
}