import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            int h = Integer.parseInt(st.nextToken());
            int o = Integer.parseInt(st.nextToken());

            if(h <= o) { 
                arr[i][0] = h;
                arr[i][1] = o;
            } else{
                arr[i][0] = o;
                arr[i][1] = h;
            }

        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });

        int L = Integer.parseInt(br.readLine());

        int max = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] road: arr){
            if(road[1] - road[0] > L) continue;

            pq.offer(road[0]);

            while(!pq.isEmpty()){
                if(road[1] - pq.peek() <= L){
                    break;
                }
                pq.poll();
            }

            max = Math.max(max, pq.size());
        }

        System.out.println(max);
    }
}