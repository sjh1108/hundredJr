import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        K = Integer.parseInt(br.readLine());

        while(K-- > 0){

            boolean check = true;
            st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            for(int i  = x; i < (N * M); i += M){
                if(i % N == y){
                    System.out.println(i + 1);
                    check = false;
                    break;
                }
            }

            if(check){
                System.out.println(-1);
            }
        }
    }
}