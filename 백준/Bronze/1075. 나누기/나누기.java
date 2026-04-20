import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int num[][];
    static int arr[][];
    static boolean visit[][];
    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };
    static int x, y;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        N /= 100;
        N *= 100;

        int ans = 0;
        while(N % M != 0){
            N++;
            ans++;
        }
        if(ans < 10){
            System.out.println("0" + ans);
        } else{
            System.out.println(ans);
        }
    }
}
