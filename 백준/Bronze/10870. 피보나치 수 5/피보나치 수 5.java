//import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int a = Fib(N);

        System.out.println(a);
    }

    static int[] fib = new int[21];
    static int Fib(int N){
        if(N == 0){
            fib[N] = 0;
            return fib[N];
        } else if(N == 1){
            fib[N] = 1;
            return fib[N];
        }
        fib[N] = Fib(N - 1) + Fib(N - 2);

        return fib[N];
    }
}