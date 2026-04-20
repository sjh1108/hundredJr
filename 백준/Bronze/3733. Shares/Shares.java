import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    static boolean[] arr;

    public static void main(String[] args) throws IOException {
        String s = null;

        while((s = br.readLine()) != null){
            st = new StringTokenizer(s);

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            sb.append(M / (N + 1)).append("\n");
        }
        System.out.println(sb);
    }
}
