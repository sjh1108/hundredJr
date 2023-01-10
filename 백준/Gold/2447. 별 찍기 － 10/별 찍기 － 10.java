//import java.util.*;
import java.io.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        boolean[][] arr = new boolean[N][N];
        star(arr, N);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(arr[i][j] == true){
                    sb.append('*');
                } else{
                    sb.append(' ');
                }
            }
            sb.append('\n');
        }
        
        System.out.println(sb);
    }
    static void paint(boolean[][] arr, int start, int end, int size){
        if(size == 3){
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(i != 1 || j != 1){
                        int x = i + start;
                        int y = end - j;
                        arr[x][y] = true;
                    }
                }
            }
        }
        else{
            for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        if(i != 1 || j != 1){
                            int nsize = size / 3;
                            int nstart = start + i * nsize;
                            int nend = (end + 1) - (nsize * j) - 1;
                            paint(arr, nstart, nend, nsize);
                        }
                    }
                }
        }
    }

    public static void star(boolean[][] arr, int N){
        paint(arr, 0, N - 1, N);
    }
}