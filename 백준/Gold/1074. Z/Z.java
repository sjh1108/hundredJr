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
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int size = (int) Math.pow(2, N);

        M = 0;

        find(size, r, c);

        System.out.println(M);
    }

    static void find(int size, int r, int c){
        if(size == 1){
            return;
        }
        int n = size / 2;
        if(r < n && c < n){
            find(n, r, c);
        }
        else if(r < n && c >= n){
            M += n * n;
            find(n, r, c - n);
        }
        else if(r >= n && c < n){
            M += n * n * 2;
            find(n, r - n, c);
        }
        else {
            M += n * n * 3;
            find(n, r - n, c - n);
        }
    }
}