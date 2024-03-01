import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] sum = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = (i == 0) ? arr[i] : sum[i-1] + arr[i];
        }

        int cnt = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < i; j++){
                if(sum[i] - sum[j] == M) cnt++;
            }
            if(sum[i] == M) cnt++;
        }
        System.out.println(cnt);
    }
}