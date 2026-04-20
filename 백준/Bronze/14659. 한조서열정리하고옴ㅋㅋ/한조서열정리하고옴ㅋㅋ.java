import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            int count = 0;
            for(int j = i + 1; j < N; j++){
                if(arr[i] > arr[j]) count++;
                else break;
            }

            M = Math.max(M, count);
        }

        System.out.println(M);
    }
}
