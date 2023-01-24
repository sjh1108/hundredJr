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

        arr = new int[N + K];
        f = new int[N - K + 1];

        max = -100000000;
        int tmp = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(i < K){
                f[tmp] += arr[i];
            } else{
                tmp++;
                f[tmp] = f[tmp - 1] + arr[i] - arr[i - K];
                max = Math.max(f[tmp], max);
            }
        }
        max = Math.max(f[0], max);

        System.out.println(max);
    }

    static int func(int i, int j){
        return arr[j] - arr[i - 1];
    }
}