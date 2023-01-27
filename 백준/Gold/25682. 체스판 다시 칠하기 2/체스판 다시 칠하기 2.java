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
    
    static int[][] arr;
    static int[][] srr;

    static long[] f;
    static long[] lrr;

    static boolean[][] brr;

    static int[][] dp;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][M + 1];
        brr = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String s = br.readLine();
            
            for(int j = 0; j < M; j++){
                char c = s.charAt(j);

                if(c == 'B'){
                    brr[i][j] = true;
                }

            }

        }

        min = Math.min(func(true), func(false));

        System.out.println(min);
    }

    static int func(boolean color){
        int count = Integer.MAX_VALUE;
        int value = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if((i + j) % 2 == 0){
                    value = (brr[i][j] != color ? 1 : 0);
                } else{
                    value = (brr[i][j] == color ? 1 : 0);
                }

                arr[i + 1][j + 1] = arr[i][j + 1] + arr[i + 1][j] - arr[i][j] + value;
            }
        }

        for(int i = 1; i <= N - K + 1; i++){
            for(int j = 1; j <= M - K + 1; j++){
                count = Math.min(count, arr[i + K - 1][j + K - 1] - arr[i + K - 1][j - 1] - arr[i - 1][j + K - 1] + arr[i - 1][j - 1]);
            }
        }
        
        return count;
    }

}