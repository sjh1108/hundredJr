import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int len = str.length();
        char[][] arr = new char[len / N][N];

        for (int i = 0; i < len; i++) {
            arr[i / N][i % N] = str.charAt(i);
        }

        for (int i = 0; i < N; i++) {
            for(int j = 0; j < len / N; j++) {
                if (j % 2 == 0) {
                    sb.append(arr[j][i]);
                } else {
                    sb.append(arr[j][N - i - 1]);
                }
            }
        }
        System.out.println(sb);
    }
}