import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int[] f;
    static int[][] arr;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        arr = new int[N][];
        arr[0] = new int[1];
        arr[0][0] = Integer.parseInt(br.readLine());
        M = 0;
        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            arr[i] = new int[i + 1];
            for(int j = 0 ; j < i + 1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        System.out.println(func());
    }

    static int func(){
        if(N == 1){
            return arr[0][0];
        }
        for(int i = 1; i < N; i++){
            for(int j = 0; j <= i; j++){
                if(j == 0){
                    arr[i][j] += arr[i-1][j];
                } else if(j == i){
                    arr[i][j] += arr[i - 1][j - 1];
                } else{
                    arr[i][j] += Math.max(arr[i - 1][j - 1], arr[i -1][j]);
                }
            }
        }
        for(int i = 0; i < N; i++){
            M = Math.max(arr[N - 1][i], M);
        }

        return M;
    }
}