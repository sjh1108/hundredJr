import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        K = Integer.parseInt(br.readLine());

        while(K-- > 0){
            N = Integer.parseInt(br.readLine());

            int quater = N / 25;
            N %= 25;
            sb.append(quater).append(' ');
            int dime = N / 10;
            N %= 10;
            sb.append(dime).append(' ');
            int nickel = N / 5;
            N %= 5;
            sb.append(nickel).append(' ');
            int penny = N;
            sb.append(penny).append(' ');

            sb.append('\n');
        }

        System.out.println(sb);
    }
}