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
            for(int j = 0; j < i; j++){
                sb.append(" ");
            }

            for(int j = 0; j < (N - i); j++){
                sb.append("*");
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }
}