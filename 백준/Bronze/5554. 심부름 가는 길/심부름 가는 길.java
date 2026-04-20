import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        int sec = 0;

        sec += Integer.parseInt(br.readLine());
        sec += Integer.parseInt(br.readLine());
        sec += Integer.parseInt(br.readLine());
        sec += Integer.parseInt(br.readLine());

        sb.append(sec / 60).append('\n').append(sec % 60);

        System.out.println(sb);
    }

}