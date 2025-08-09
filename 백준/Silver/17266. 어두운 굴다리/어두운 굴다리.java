import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        pq.add(Integer.parseInt(st.nextToken()) << 1);
        int before = pq.peek();

        for(int i = 1; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            pq.add(num - before);
            before = num;
        }
        pq.add((N - before) << 1);

        int max = pq.poll();
        if((max & 1) == 0){
            max /= 2;
        } else{
            max = (max + 1) / 2;
        }

        System.out.println(max);
    }
}
