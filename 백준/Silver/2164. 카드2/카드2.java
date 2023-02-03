import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static long K;
    
    static int[] arr;
    static int[] f;
    static boolean[] brr;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<>();

        if(N < 2){
            System.out.println(1);
            System.exit(0);
        }
        for(int i = 1; i <= N; i++){
            q.add(i);
        }

        int tmp = 0;

        while(true){
            q.remove();

            tmp = q.poll();

            if(q.size() < 1){
                break;
            }

            q.add(tmp);
        }

        System.out.println(tmp);
    }
}