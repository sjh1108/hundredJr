import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int num[][];
    static int arr[][];
    static boolean visit[][];
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int x, y;

    public static void main(String[] args) throws IOException {
        int h = 0, m = 0, s = 0;
        int H = 0, M = 0, S = 0;
        
        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());

            H = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            S = Integer.parseInt(st.nextToken());

            int start = (h * 3600) + (m * 60) + s;
            int end = (H * 3600) + (M * 60) + S;
            end -= start;
            h = end / 3600;
            m = (end % 3600) / 60;
            s = (end % 3600) % 60;

            sb.append(h).append(" ").append(m).append(" ").append(s);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
