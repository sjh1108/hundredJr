import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());

            sb.append(n - num);
            sb.append(' ');
        }

        System.out.println(sb);
    }
}