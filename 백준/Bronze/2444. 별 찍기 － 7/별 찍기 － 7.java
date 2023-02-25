import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;

    static int[] arr;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            for(int j = 0; j < N - i; j++){
                sb.append(' ');
            }

            for(int j = 0; j < (2 * i) - 1; j++){
                sb.append('*');
            }
            
            sb.append('\n');
        }

        for(int i = 1; i < N; i++){
            for(int j = 0; j < i; j++){
                sb.append(' ');
            }
            for(int j = 0; j < (2 * (N - i)) - 1; j++){
                sb.append('*');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}