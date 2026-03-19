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
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        arr[1] = 1;

        int min = 0;
        for(int i = 2; i <= N; i++){
            min = Integer.MAX_VALUE;

            for(int j = 1; j * j <= i; j++){
                int tmp = i - j * j;
                min = Math.min(min, arr[tmp]);
            }

            arr[i] = min + 1;
        }

        System.out.println(arr[N]);
    }
}