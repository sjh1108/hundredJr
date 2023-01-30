import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static long K;
    
    static int[] arr;
    static int[] f;
    static boolean[] brr;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        int pivot = -1;
        int sum = 0;
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(br.readLine());

            if(n == 0){
                sum -= arr[pivot--];
            } else{
                arr[++pivot] = n;
                sum += arr[pivot];
            }
        }
        System.out.println(sum);

    }
}