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

        f = new int[N + 1];
        func();

        System.out.println(f[N]);
    }

    static void func(){
        f[1] = 0;
        for(int i = 2; i < N + 1; i++){
            if(i % 2 == 0 || i % 3 == 0){
                if(i % 6 == 0){
                    f[i] = Math.min(f[i - 1], Math.min(f[i / 2], f[i / 3])) + 1;
                    continue;
                }
                if(i % 2 == 0){
                    f[i] = Math.min(f[i - 1], f[i / 2]) + 1;
                }
                if(i % 3 == 0){
                    f[i] = Math.min(f[i - 1], f[i / 3]) + 1;
                }

                continue;
            }

            f[i] = f[i - 1] + 1;
        }
    }
}