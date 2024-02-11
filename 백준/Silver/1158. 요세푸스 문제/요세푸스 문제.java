import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= n; i++) q.offer(i);

        sb.append("<");

        while(!q.isEmpty()){
            for(int i = 0; i < k-1; i++){
                q.offer(q.poll());
            }
            sb.append(q.poll());
            if(!q.isEmpty()) sb.append(", ");
        }

        sb.append(">");

        System.out.println(sb);
    }
}