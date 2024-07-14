import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        int[] arr = new int[1025];
        arr[1] = 1;
        for(int i = 2; i < 1025; i++) {
            arr[i] = i >> 1;
        }
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            boolean flag = true;
            while(flag){
                if(N == M) {
                    flag = false;
                    break;
                }
                if(N > M) {
                    N = arr[N];
                } else {
                    M = arr[M];
                }
            }

            sb.append(N*10).append("\n");
        }
        System.out.println(sb);
    }
}