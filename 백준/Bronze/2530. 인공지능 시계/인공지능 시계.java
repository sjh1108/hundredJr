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
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        s += N;
        m += s / 60;
        s %= 60;
        h += m / 60;
        m %= 60;
        h %= 24;

        System.out.println(h + " " + m + " " + s);
    }

}