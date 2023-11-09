import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        boolean[][] arr = new boolean[N][M];
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < M; j++){
                if(s.charAt(j) == 'X') arr[i][j] = true;
            }
        }

        // row
        int rowNum = 0;
        for(int i = 0; i < N; i++){
            boolean flag = true;
            for(int j = 0; j < M; j++){
                if(arr[i][j]){
                    flag = false;
                    break;
                }
            }
            if(flag) rowNum++;
        }

        // col
        int colNum = 0;
        for(int j = 0; j < M; j++){
            boolean flag = true;
            for(int i = 0; i < N; i++){
                if(arr[i][j]){
                    flag = false;
                    break;
                }
            }
            if(flag) colNum++;
        }

        System.out.println(Math.max(rowNum, colNum));
    }
}