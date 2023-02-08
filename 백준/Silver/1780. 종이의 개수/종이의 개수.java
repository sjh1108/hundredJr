import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static long K;
    
    static int[][] dp;

    static int mCnt, zCnt, pCnt;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        dp = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            // String s = br.readLine();

            for(int j = 0; j < N; j++){
                // char c = s.charAt(j);

                // dp[i][j] = c - '0';
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        mCnt = zCnt = pCnt = 0;
        countBlock(0, 0, N);

        // System.out.println(sb);

        System.out.println(mCnt);
        System.out.println(zCnt);
        System.out.println(pCnt);
    }


    static boolean checkBlock(int row, int col, int size){

        for(int i = row; i < row + size; i++){
            for(int j = col; j < col + size; j++){
                if(dp[i][j] != dp[row][col]) return false;
            }
        }

        return true;
    }

    static void countBlock(int row, int col, int size){

        if(checkBlock(row, col, size)){

            if(dp[row][col] == 1){
                pCnt++;
                // sb.append(1);
            } 

            else if(dp[row][col] == 0){
                zCnt++;
            }
            
            else{
                mCnt++;
                // sb.append(0);
            }

            return; 
        }

        size /= 3;

        // sb.append('(');
        countBlock(row, col, size);
        countBlock(row, col + size, size);
        countBlock(row, col + (size * 2), size);

        countBlock(row + size, col, size);
        countBlock(row + size, col + size, size);
        countBlock(row + size, col + (size * 2), size);

        countBlock(row + (size * 2), col, size);
        countBlock(row + (size * 2), col + size, size);
        countBlock(row + (size * 2), col + (size * 2), size);
        // sb.append(')');
    }
}