import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int min = 100000;
    static int M = 1;

    static int[][] arr;
    static int sLv = 0;
    static int[] sarr;
    static int lLv = 0;
    static int[] larr;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1][N + 1];
        sarr = new int[N / 2];
        larr = new int[N / 2];

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        calculate(0, 0, 1);

        System.out.println(min);
    }

    static void calculate(int sp, int lp, int tmp){
        if(sp + lp == N){
            for(int i = 0; i < sp; i++){
                for(int j = i + 1; j < sp; j++){
                    sLv += arr[sarr[i]][sarr[j]];
                    sLv += arr[sarr[j]][sarr[i]];
                }
            }

            for(int i = 0; i < lp; i++){
                for(int j = i + 1; j < lp; j++){
                    lLv += arr[larr[i]][larr[j]];
                    lLv += arr[larr[j]][larr[i]];
                }
            }
            int cnt = Math.abs(sLv - lLv);
            min = Math.min(cnt, min);

            lLv = 0;
            sLv = 0;
            return;
        }

        if(sp < (N / 2)){
            sarr[sp] = tmp;
            calculate(sp + 1, lp, tmp + 1);
        }
        if(lp < (N / 2)){
            larr[lp] = tmp;
            calculate(sp, lp + 1, tmp + 1);
        }
    }
}