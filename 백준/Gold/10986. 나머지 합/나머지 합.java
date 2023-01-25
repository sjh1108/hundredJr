import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int max;
    
    static int[] arr;
    static int[] srr;

    static long[] f;
    static long[] lrr;

    static int[][] dp;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];

        long count = 0;
        f = new long[M];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++){
            arr[i] = (arr[i - 1] + Integer.parseInt(st.nextToken())) % M;
            if(arr[i] == 0){
                count++;
            }

            f[(int) arr[i]]++;
        }

        for(int i = 0 ; i < M; i++){
            if(f[i] > 1){
                count += (f[i] * (f[i] - 1)) / 2;
            }
        }

        System.out.println(count);
    }

    static int func(int i, int j){
        return arr[j] - arr[i - 1];
    }

}