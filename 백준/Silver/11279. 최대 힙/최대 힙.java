import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        while(T-- > 0){
            int tmp = Integer.parseInt(br.readLine());

            if(tmp != 0){
                q.add(tmp);
            } else{
                if(q.isEmpty()){
                    sb.append(0);
                } else{
                    sb.append(q.poll());
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }
}