import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] arr;
    static boolean[][] visited;
    static int size;

    public static void main(String[] args) throws IOException {
        N = 1000 - Integer.parseInt(br.readLine());

        int[] coin = {500, 100, 50, 10, 5, 1};
        int cnt = 0;
        for (int i = 0; i < 6; i++) {
            cnt += N / coin[i];
            N %= coin[i];
        }
        System.out.println(cnt);
    }
}