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

        arr = new int[N + 1][2];
        for(int i = 1; i < N + 1; i++){
            arr[i][0] = Integer.parseInt(br.readLine());
        }
        
        System.out.println(func());
    }

    static int func(){
        if(N == 1){
            return arr[1][0];
        } else if(N == 2){
            return arr[2][1] = arr[1][0] + arr[2][0];
        }
        
        arr[2][1] = arr[1][0] + arr[2][0];

        for(int i = 3; i <= N; i++){
            arr[i][1] = arr[i][0] + arr[i - 1][0];
            arr[i][0] += Math.max(arr[i - 2][1], arr[i - 2][0]);
        }

        M = Math.max(arr[N][0], arr[N][1]);
        return M;
    }
}