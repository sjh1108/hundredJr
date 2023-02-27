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

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int primeNum = 0;

        int tmp = 0;
        for(int i = 1; i <= N; i++){
            if(N % i == 0){
                tmp++;
                if(tmp == M){
                    primeNum = i;
                    break;
                }
            }
        }

        System.out.println(primeNum);
    }

}