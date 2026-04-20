import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void main(String[] args) throws IOException {
        int x = -1;
        int cnt = 1;
        while(x != 0){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            if(x == 0) break;

            sb.append("Case ").append(cnt++).append(": Sorting... done!\n");
        }

        System.out.println(sb);
    }
}
