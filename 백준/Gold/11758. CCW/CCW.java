import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken()); int y1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken()); int y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken()); int y3 = Integer.parseInt(st.nextToken());

        int a = x1 * y2 + x2 * y3 + x3 * y1;
        int b = x2 * y1 + x3 * y2 + x1 * y3;

        if(a - b > 0) System.out.println(1);
        else if(a - b < 0) System.out.println(-1);
        else System.out.println(0);
        
    }
}