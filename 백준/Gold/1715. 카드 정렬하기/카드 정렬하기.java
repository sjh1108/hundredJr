import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        N = Integer.parseInt(br.readLine());

        while(N-- > 0) {
            pq.add(Long.parseLong(br.readLine()));
        }

        long result = 0;

        while(pq.size() > 1) {
            long a = pq.poll();
            long b = pq.poll();
            result += a + b;
            pq.add(a + b);
        }

        System.out.println(result);
    }
}