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

        arr = new int[N + 1];
        brr = new boolean[N + 1];
        int tmp = 0;
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(br.readLine());

            if(tmp < n){
                for(int j = tmp; j <= n; j++){
                    if(j == 0) continue;
                    if(arr[j] == 0){
                        arr[j] = 1;
                        sb.append('+').append('\n');
                    }
                }
                arr[n] = 2;
                sb.append('-').append('\n');
                for(int j = n - 1; j > 0; j--){
                    if(arr[j] < 2){
                        tmp = j;
                        break;
                    }
                }
            } else{
                for(int j = tmp; j > n; j--){
                    if(arr[j] == 1){
                        System.out.println("NO");
                        System.exit(0);
                    }
                }

                arr[n] = 2;
                sb.append('-').append('\n');
                for(int j = n - 1; j > 0; j--){
                    if(arr[j] < 2){
                        tmp = j;
                        break;
                    }
                }
            }
        }

        System.out.println(sb);
    }
}