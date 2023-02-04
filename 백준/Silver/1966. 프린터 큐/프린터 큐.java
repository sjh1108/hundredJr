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
    static int[] f;
    static boolean[] brr;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        K = Integer.parseInt(br.readLine());

        LinkedList<Integer> q = new LinkedList<>();
        for(int qqq = 0; qqq < K; qqq++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int tmp = 0;
            for(int i = 0; i < N; i++){
                int p = Integer.parseInt(st.nextToken());
                if(i == M){
                    tmp = (-1) * p;
                    q.offer(tmp);
                } else{
                    q.offer(p);
                }
            }

            int count = 1;
            while(true){
                int p = q.poll();

                boolean isMax = true;
                for(int i = 0; i < q.size(); i++){
                    if(Math.abs(p) < Math.abs(q.get(i))){
                        isMax = false;

                        q.offer(p);
                        for(int j = 0; j < i; j++){
                            q.offer(q.poll());
                        }

                        break;
                    }
                }

                if(!isMax){
                    continue;
                }

                if(p == tmp){
                    break;
                }
                count++;
            }

            q.clear();

            sb.append(count).append('\n');
        }

        System.out.println(sb);
    }
}