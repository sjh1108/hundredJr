import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static long[] f;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        f = new long[101];

        f[1] = 1;
        f[2] = 1;
        f[3] = 1;
        f[4] = 2;
        f[5] = 2;

        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(br.readLine());

            sb.append(func(n));
            sb.append('\n');
        }
        
        System.out.println(sb);
    }

    static long func(int n){
        if(f[n] != 0){
            return f[n];
        }
        if(n < 4){
            return f[n] = 1;
        } else if(n < 6){
            return f[n] = 2;
        }

        f[n] = func(n - 1) + func(n - 5);

        return f[n];
    }
}