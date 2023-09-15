import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        long N = Long.parseLong(br.readLine());

        for(long i = 1; i <= N; i++){
            sb.append(i).append(' ');
            if(i % 6 == 0 || i == N) sb.append("Go! ");
        }

        System.out.println(sb);
    }
}