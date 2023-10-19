import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String s = br.readLine();

            char c = s.charAt(0);
            sb.append(c);
            for(int j = 1; j < s.length(); j++){
                char now = s.charAt(j);
                if(now == c) continue;
                else{
                    sb.append(now);
                    c = now;
                }
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}