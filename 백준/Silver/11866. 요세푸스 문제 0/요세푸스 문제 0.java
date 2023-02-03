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
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Queue<Integer> q = new LinkedList<>();
        
        if(N < 2){
            System.out.println("<1>");
            System.exit(0);
        }

        for(int i = 1; i <= N; i++){
            q.add(i);
        }

        int tmp = 0;

        sb.append('<');

        while(true){
            for(int i = 0; i < M - 1; i++){
                q.add(q.poll());
            }

            tmp = q.poll();

            sb.append(tmp).append(',').append(' ');

            if(q.size() == 1){
                sb.append(q.poll());
                break;
            }
        }
        sb.append('>');

        System.out.println(sb);
    }
}