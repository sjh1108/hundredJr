import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++){
            int m = Integer.parseInt(br.readLine());
            sb.append(m/2+1 + "\n");
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();

            int cnt = 0;
            StringTokenizer st = null;
            for(int i = 0; i < m; i++){
                if(i % 10 == 0){
                    st = new StringTokenizer(br.readLine());
                }

                int x = Integer.parseInt(st.nextToken());

                if(i % 2 == 0){
                    maxQueue.add(x);
                } else{
                    minQueue.add(x);
                }
                
                if(!minQueue.isEmpty()){
                    if(maxQueue.peek() > minQueue.peek()){
                        int t1 = maxQueue.poll();
                        int t2 = minQueue.poll();

                        maxQueue.offer(t2);
                        minQueue.offer(t1);
                    }
                }

                if(i % 2 == 0){
                    sb.append(maxQueue.peek());
                    if(cnt == 9 | i == m - 1){
                        sb.append("\n");
                        cnt = 0;
                    } else{
                        sb.append(' ');
                    }
                    cnt++;
                }
            }
        }

        System.out.println(sb);
    }
}