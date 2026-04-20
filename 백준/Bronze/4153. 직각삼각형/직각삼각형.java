import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        long a, b, c;

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0 && c == 0) break;
            a = (long) Math.pow(a, 2);
            b = (long) Math.pow(b, 2);
            c = (long) Math.pow(c, 2);
            if(c == a + b || a == b + c || b == c + a){
                sb.append("right");
            } else{
                sb.append("wrong");
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}