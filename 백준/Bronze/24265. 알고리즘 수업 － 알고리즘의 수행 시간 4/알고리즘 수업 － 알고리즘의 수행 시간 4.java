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

    static int[][] cabbage;
    static boolean[][] visit;
	static int[] dx = { 0, -1, 0, 1 };
	static int[] dy = { 1, 0, -1, 0 };

    public static void main(String[] args) throws IOException{
        long n = Long.parseLong(br.readLine());
        System.out.println(n * (n - 1)  / 2);
        System.out.println(2);
    }
}