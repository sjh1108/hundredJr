import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M, K;
    
    static int[] arr;
    static int[] f;
    static boolean[] brr;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine()) - 1;

        int dist = 0;
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dist += arr[i];
        }

        f = new int[N];
        M = Integer.MAX_VALUE;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            f[i] = Integer.parseInt(st.nextToken());
            M = Math.min(f[i], M);
        }

        int newDis = 0;
        K = 0;

        for(int i = 0; i < N && dist > 0; i++){
            if(f[i] == M){
                K += dist * f[i];
                break;
            }
            K += arr[i] * f[i];
            for(int j = i + 1; j < N; j++){
                if(f[i] < f[j]){
                    newDis += arr[j];
                    K += arr[j] * f[i];
                } else{
                    i = j - 1;
                    break;
                }
            }
            K += newDis * f[i];
            dist -= newDis + arr[i];
            newDis = 0;
        }

        System.out.println(K);
    }
}