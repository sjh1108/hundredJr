import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        double x = -1, y = -1;

        while(!(x==0 && y == 0)){
            st = new StringTokenizer(br.readLine());
            x = Double.parseDouble(st.nextToken());
            y = Double.parseDouble(st.nextToken());

            if(x == 0 || y == 0) sb.append("AXIS");
            else if(x > 0 && y > 0) sb.append("Q1");
            else if(x < 0 && y > 0) sb.append("Q2");
            else if(x < 0 && y < 0) sb.append("Q3");
            else sb.append("Q4");

            sb.append('\n');
        }

        System.out.println(sb);
    }
}