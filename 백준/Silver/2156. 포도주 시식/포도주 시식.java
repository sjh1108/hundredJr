import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int[] f;
    static int[][] arr;
    final static long mod = 1000000000;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1][3];
        for(int i = 0; i < N; i++){
            arr[i][0] = Integer.parseInt(br.readLine());
        }

        if(N == 1){
            M = arr[0][0];
        } else {
            arr[1][1] = arr[1][0] + arr[0][0];
            arr[1][2] = arr[0][0];
            func();
        }

        System.out.println(M);
    }

    static void func(){
        for(int i = 2; i < N + 1; i++){
            arr[i][2] = Math.max(arr[i - 1][0], Math.max(arr[i - 1][1], arr[i - 1][2]));
            arr[i][1] = arr[i][0] + arr[i - 1][0];
            arr[i][0] += arr[i - 1][2];
        }

        M = Math.max(arr[N][1], Math.max(arr[N][0], arr[N][2]));
    }
}