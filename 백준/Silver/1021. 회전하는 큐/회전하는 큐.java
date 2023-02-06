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

        LinkedList<Integer> q = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            q.offer(i);
        }

        int cnt = 0;
        st = new StringTokenizer(br.readLine());
        while(M-- > 0){
            int fnum = Integer.parseInt(st.nextToken());

            if(q.getFirst() == fnum){
                q.poll();
                continue;
            }

            int tmp = q.indexOf(fnum);
            int len = 0;
            if(q.size() % 2 == 0){
                len = q.size() / 2 - 1;
            }
            else{
                len = q.size() / 2;
            }

            if(tmp <= len){
                for(int i = 0; i < tmp; i++){
                    q.offerLast(q.pollFirst());
                    cnt++;
                }
            } else{
                for(int i = 0; i < q.size() - tmp; i++){
                    q.offerFirst(q.pollLast());
                    cnt++;
                }
            }

            q.poll();
        }

        System.out.println(cnt);
    }
}