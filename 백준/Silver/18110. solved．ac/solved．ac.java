import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int x = (int)(Math.round(N * 0.15));
        Arrays.sort(arr);

        double sum = 0;
        for(int i = x; i < N-x; i++){
            sum += arr[i];
        }
        sum /= N - (2 * x);

        System.out.println((Math.round(sum)));
    }
}