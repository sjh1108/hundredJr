import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] meets = new int[N][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            meets[i][0] = Integer.parseInt(st.nextToken());
            meets[i][1] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);
        for(int[] meet: meets) pq.add(meet);

        int ans = 0;
        int[] rooms = new int[K];

        while(!pq.isEmpty()){
            int[] meet = pq.poll();
            int s = meet[0];
            int e = meet[1];

            int best = -1;
            for(int i = 0; i < K; i++){
                if(rooms[i] < s && (best == -1 || rooms[i] > rooms[best])){
                    best = i;
                }
            }
            if(best != -1){
                rooms[best] = e;
                ++ans;
            }
        }   

        System.out.println(ans);
    }
}