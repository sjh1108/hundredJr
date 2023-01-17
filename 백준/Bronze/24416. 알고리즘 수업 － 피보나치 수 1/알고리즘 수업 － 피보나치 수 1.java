// import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int[] f;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        f = new int[N + 2];

        sb.append(fibonacci(N));
        sb.append(' ');
        sb.append(N - 2);

        System.out.println(sb);
        
    }
    static int fibonacci(int n){
        f[1] = f[2] = 1;
        for(int i = 3; i <= n; i++){
            f[i] = f[i-1] + f[i - 2];
        }
        return f[n];
    }
}