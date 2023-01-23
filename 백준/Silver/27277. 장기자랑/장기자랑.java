import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;
    static int[] f;
    static int[] arr;
    final static long mod = 1000000000;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr[0] = 0;
        for(int i = 1; i < N + 1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int sum = 0;
        int tmp = (N + 1) / 2;

        for(int i = 0; i <= N / 2; i++){
            int n = Math.max(0, arr[i + tmp] - arr[i]);
            sum += n;
        }
        

        System.out.println(sum);
    }
}