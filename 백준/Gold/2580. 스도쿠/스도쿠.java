import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;

    static int[][] arr = new int[9][9];
    
    static void sudoku(int x, int y){

        if(y == 9){
            sudoku(x + 1, 0);
            return;
        }
        if(x == 9){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }
    
        if(arr[x][y] == 0){
            for(int i = 1; i <= 9; i++){
                if(possibility(x, y, i)){
                    arr[x][y] = i;
                    sudoku(x, y + 1);
                }
            }
            arr[x][y] = 0;
            return;
        }

        
        sudoku(x, y + 1);
    }

    static boolean possibility(int x, int y, int n){
        for(int i = 0; i < 9; i++){
            if(arr[x][i] == n){
                return false;
            }

            if(arr[i][y] == n){
                return false;
            }
        }        

        int nx = (x / 3) * 3;
        int ny = (y / 3) * 3;

        for(int i = nx; i < nx + 3; i++){
            for(int j = ny; j < ny + 3; j++){
                if(arr[i][j] == n){
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException{
        N = 0;
        for(int i = 0; i < 9; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 9; j++){
                int n = Integer.parseInt(st.nextToken());
                arr[i][j] = n;
            }
        }
        sudoku(0, 0);
    }
}