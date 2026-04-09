import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] lectures = new int[N][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            lectures[i][0] = s; lectures[i][1] = e;
        }

        Arrays.sort(lectures, Comparator.comparingInt(o -> o[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            if(!pq.isEmpty() && pq.peek() <= lectures[i][0]){
                pq.poll();
            }
            pq.offer(lectures[i][1]);
        }

        System.out.println(pq.size());
    }
}