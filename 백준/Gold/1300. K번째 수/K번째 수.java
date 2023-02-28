import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;

    static int[][] arr;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        long lo = 1;
        long hi = M;

        while(lo < hi){
            long mid = (lo + hi) / 2;
            long count = 0;

            for(int i = 1; i <= N; i++){
                count += Math.min(mid / i, N);
            }

            if(M <= count){
                hi = mid;
            }

            else{
                lo = mid + 1;
            }
        }

        System.out.println(lo);
    }

}