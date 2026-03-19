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

        arr = new int[1002];

        arr[1] = 1;
        arr[2] = 2;

        for(int i = 3; i <= N; i++){
            arr[i] = (arr[i - 2] + arr[i - 1]) % 10007;
        }
        System.out.println(arr[N]);
    }
}