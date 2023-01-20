import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int[] f;
    static int[] arr;
    final static long mod = 1000000000;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        f = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        func();


        M = -1;

        for(int i = N - 1; i >= 0; i--){
            M = f[i] > M ? f[i] : M;

            if(M > i) break;
        }
        

        System.out.println(M);
    }

    static void func(){
        for(int i = 0; i < N; i++){
            f[i] = 1;

            for(int j = 0; j < i; j++){
                
                if(arr[j] < arr[i] && f[i] < f[j] + 1){
                    f[i] = f[j] + 1;
                }

            }
        }
    }
}