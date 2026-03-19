import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = N - 1; i > 0; i--){
            arr[i] -= arr[i - 1];
        }

        long g = arr[1];
        for(int i = 2; i < N; i++){
            g = (g > arr[i] ? gcd(g, arr[i]) : gcd(arr[i], g));
            
            if(g == 1) break;
        }
        
        long sum = 0;
        for(int i = 1; i < N; i++){
            sum += (arr[i] / g) - 1;
        }
        
        System.out.println(sum);
    }

    static long gcd(long a, long b){
        while(b > 0){
            long tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
}