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

        int[][] arr = new int[N][3];
        arr[0][0] = arr[0][1] = arr[0][2] = 1;
        for(int i = 1; i < N; i++){
            arr[i][0] = (arr[i-1][0] + arr[i-1][1] + arr[i-1][2]) % 9901;
            arr[i][1] = (arr[i-1][0] + arr[i-1][2]) % 9901;
            arr[i][2] = (arr[i-1][0] + arr[i-1][1]) % 9901;
        }

        System.out.println((arr[N-1][0] + arr[N-1][1] + arr[N-1][2]) % 9901);
    }
}