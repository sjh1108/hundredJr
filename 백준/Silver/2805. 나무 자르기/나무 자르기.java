import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;

    static int[] wood;
    
    // static long[][] dp = {{1, 1}, {1, 0}};
    final static long p = 1000000007;
    static boolean isEnd = false;


    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        wood = new int[N];

        st = new StringTokenizer(br.readLine());

        int min = 0, max = 0;
        for(int i = 0; i < N; i++){
            wood[i] = Integer.parseInt(st.nextToken());
            if(wood[i] > max){
                max = wood[i];
            }
        }

        while(min < max){
            int mid = (min + max) / 2;
            long sum = 0;
            for(int woodlength : wood){
                if(woodlength - mid > 0){
                    sum += (woodlength - mid);
                }
            }

            if(sum < M){
                max = mid;
            }

            else{
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}