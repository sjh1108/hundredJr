import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        
        Long N = Long.parseLong(st.nextToken());
        Long M = Long.parseLong(st.nextToken());

        long n2 = two(N) - two(N - M) - two(M);
        long n5 = five(N) - five(N - M) - five(M);
        long tmp = Math.min(n2, n5);

        System.out.println(tmp);
    }
    static long five(long num){
        int count = 0;

        while(num >= 5){
            count += (num / 5);
            num /= 5;
        }

        return count;
    }
    static long two(long num){
        int count = 0;

        while(num >= 2){
            count += (num / 2);
            num /= 2;
        }

        return count;
    }
}