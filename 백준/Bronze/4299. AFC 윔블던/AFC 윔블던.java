import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int sum = Integer.parseInt(st.nextToken()), sub = Integer.parseInt(st.nextToken());

        int a = (sum + sub), b = sum - sub;
        if(a % 2 == 1 || sum < sub) {
            System.out.println(-1);
            return;
        } else {
            a /= 2;
        }
        b = sum - a;
        System.out.println(a + " " + b);
    }
}
