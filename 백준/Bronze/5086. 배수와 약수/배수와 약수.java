import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int n, m;
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            if(m == 0 && n == 0) break;
            
            if(m % n == 0){
                sb.append("factor");
            } else if(n % m == 0){
                sb.append("multiple");
            } else{
                sb.append("neither");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}