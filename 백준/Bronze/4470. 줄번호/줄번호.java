import java.util.*;
import java.io.*;

class Node{
    int x;
    int y;
    int d;

    Node(int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}
public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new
    // OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++){
            sb.append(i).append(". ").append(br.readLine()).append('\n');
        }
        System.out.println(sb);
    }

}