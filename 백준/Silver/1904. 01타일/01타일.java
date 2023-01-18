import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int[] f;
    static int[][][] far = new int[21][21][21];

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        
        M = 0;
        f = new int[N + 1];

        func(0);
        System.out.println(f[N - 1]);
    }

    static void func(int n){
        f[0] = 1;
        f[1] = 2;
        if(N <= 2){
            return;
        }

        for(int i = 2; i < N; i++){
            f[i] = (f[i - 1] + f[i - 2]) % 15746;
        }
    }
}