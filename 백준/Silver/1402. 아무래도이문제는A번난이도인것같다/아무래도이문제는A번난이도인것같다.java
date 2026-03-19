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
        for(int i = 0; i < N; i++){
            sb.append('y').append('e').append('s').append('\n');
        }
        System.out.println(sb);
    }
}