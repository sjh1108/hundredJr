import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
    
        int n = Integer.parseInt(st.nextToken());

        while(n != 0){
            int sum = 1;
            while(n-- > 0){
                sum *= Integer.parseInt(st.nextToken());
                sum -= Integer.parseInt(st.nextToken());
            }

            sb.append(sum).append('\n');
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
        }

        System.out.println(sb);
    }
}