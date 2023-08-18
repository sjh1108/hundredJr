import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        boolean[] brr = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i++){
            brr[i] = Integer.parseInt(st.nextToken()) == 0 ? true : false;
        }

        st = new StringTokenizer(br.readLine());
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0; i < N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(brr[i]){
                dq.addLast(tmp);
            }
        }
     
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int idx = 0; idx < M; idx++){
            int tmp = Integer.parseInt(st.nextToken());
            
            dq.addFirst(tmp);

            sb.append(dq.pollLast()).append(" ");
        }

        System.out.println(sb);
    }
}