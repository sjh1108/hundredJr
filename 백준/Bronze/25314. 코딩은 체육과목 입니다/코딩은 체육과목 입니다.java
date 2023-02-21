import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        N /= 4;

        for(int i = 0; i < N; i++){
            sb.append("long ");
        }
        sb.append("int");

        System.out.println(sb);
    }
}