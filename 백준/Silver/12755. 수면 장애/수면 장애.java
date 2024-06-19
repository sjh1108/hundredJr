import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        
        int digit = 1;
        int i = 2;
        int j = 1;
        int prev = 9;
        int max = 9;

        if(N < 10){
            System.out.println(N);
            return;
        }

        while(true){
            max += 9 * (int) Math.pow(10, j) * i;
            if(prev < N && N <= max){
                // System.out.println(i);
                break;
            }

            i++;
            j++;
            prev = max;
        }

        int cnt = (N - (prev + 1)) / i;
        int num = (int) Math.pow(10, j) + cnt;
        String numStr = Integer.toString(num);
        int idx = (N - (prev + 1)) % i;
        System.out.println(numStr.charAt(idx));
    }
}