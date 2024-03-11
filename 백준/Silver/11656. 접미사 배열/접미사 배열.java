import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        String s = br.readLine();

        int len = s.length();
        String[] arr = new String[len];
        for (int i = 0; i < len; i++) {
            arr[i] = s.substring(i);
        }
        Arrays.sort(arr);

        for (int i = 0; i < len; i++) {
            sb.append(arr[i]).append('\n');
        }
        System.out.println(sb);
    }
}