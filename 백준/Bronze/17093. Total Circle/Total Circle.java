import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        long[][] q = new long[Q][2];
        long[][] p = new long[P][2];

        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            q[i][0] = Long.parseLong(st.nextToken());
            q[i][1] = Long.parseLong(st.nextToken());
        }

        for(int i = 0; i < P; i++){
            st = new StringTokenizer(br.readLine());
            p[i][0] = Integer.parseInt(st.nextToken());
            p[i][1] = Integer.parseInt(st.nextToken());
        }

        long max = 0;
        for(int i = 0; i < Q; i++){
            for(int j = 0; j < P; j++){
                long x = p[j][0] - q[i][0];
                long y = p[j][1] - q[i][1];
                max = Math.max(max, x * x + y * y);
            }
        }

        System.out.println(max);
    }
}