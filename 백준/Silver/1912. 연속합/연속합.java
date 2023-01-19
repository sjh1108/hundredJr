import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static long max;
    static int[] f;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        f = new int[N];
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        max = -1000000;
        f[0] = Integer.parseInt(st.nextToken());
             
        for(int i = 1; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            f[i] = n;
            if(f[i - 1] >= 0) f[i] = f[i] + f[i - 1];
        }
        func();
        sb.append(max);
        
        System.out.println(sb);
    }

    static void func(){
        
        for(int i = 0; i < N; i++){
            max = Math.max(max, f[i]);
        }
        
    }
}