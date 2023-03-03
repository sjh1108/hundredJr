import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;

    static int[] arr;
    static Integer[][] fib;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        fib = new Integer[41][2];

        fib[0][0] = 1;
        fib[0][1] = 0;
        fib[1][0] = 0;
        fib[1][1] = 1;

        while(N-- > 0){
            int get = Integer.parseInt(br.readLine());

            sb.append(Fib(get)[0]).append(' ').append(Fib(get)[1]);

            sb.append('\n');
        }

        System.out.println(sb);
    }

    static Integer[] Fib(int n) {

        if(fib[n][0] == null || fib[n][1] == null){
            fib[n][0] = Fib(n - 1)[0] + Fib(n - 2)[0];
            fib[n][1] = Fib(n - 1)[1] + Fib(n - 2)[1];
        }

        return fib[n];
    }
}