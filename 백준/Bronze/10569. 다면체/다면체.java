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

        while(N-- > 0){
            st = new StringTokenizer(br.readLine());

            int n = -1 * Integer.parseInt(st.nextToken());
            n += Integer.parseInt(st.nextToken());
            n += 2;
            sb.append(n).append('\n');
        }

        System.out.println(sb);
    }

}