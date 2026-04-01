import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Queue<Long> pq = new PriorityQueue<>();
        while(M-- > 0) pq.add(0L);
        while(N-- > 0) pq.add(pq.remove() + Integer.parseInt(st.nextToken()));

        System.out.println(pq.poll() > K ? "GO" : "WAIT");
    }
}