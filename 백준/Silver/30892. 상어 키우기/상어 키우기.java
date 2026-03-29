import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long T = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> loadQueue = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            loadQueue.add(Long.parseLong(st.nextToken()));
        }

        PriorityQueue<Long> readyQueue = new PriorityQueue<>(Comparator.reverseOrder());
        while(K-- > 0){
            while(loadQueue.size() > 0 && loadQueue.peek() < T){
                readyQueue.add(loadQueue.poll());
            }

            if(readyQueue.size() > 0){
                T += readyQueue.poll();
            }
        }

        System.out.println(T);
    }
}