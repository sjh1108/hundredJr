import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static long K;
    
    static int bcnt, wcnt;

    static int[][] dp;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        dp = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++){
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        countBlock(0, 0, N);

        System.out.println(wcnt);
        System.out.println(bcnt);
    }


    static boolean checkBlock(int row, int col, int size){
        int tmp = dp[row][col];

        for(int i = row; i < row + size; i++){
            for(int j = col; j < col + size; j++){
                if(dp[i][j] != tmp) return false;
            }
        }

        return true;
    }

    static void countBlock(int row, int col, int size){

        if(checkBlock(row, col, size)){
            if(dp[row][col] == 1){
                bcnt = bcnt + 1;
            } else{
                wcnt = wcnt + 1;
            }

            return; 
        }

        size /= 2;

        countBlock(row, col, size);
        countBlock(row + size, col, size);
        countBlock(row, col + size, size);
        countBlock(row + size, col + size, size);
    }
}