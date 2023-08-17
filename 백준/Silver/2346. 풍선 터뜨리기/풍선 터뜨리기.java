import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dq.add(new int[]{i, arr[i]});
        }

        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            sb.append(cur[0]).append(" ");

            int dir = cur[1];
            try{
                if(dir > 0){
                    dir--;
                    for(int i = 0; i < dir; i++){
                        dq.addLast(dq.pollFirst());
                    }
                } else{
                    for(int i = dir; i < 0; i++){
                        dq.addFirst(dq.pollLast());
                    }
                }
            }
            catch(NullPointerException e){
                System.out.println(sb);
                return;
            }
        }

    }
}