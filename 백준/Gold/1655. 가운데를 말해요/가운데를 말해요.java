import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 오름차순
        PriorityQueue<Integer> upper = new PriorityQueue<>();
        // 내림차순
        PriorityQueue<Integer> lower = new PriorityQueue<>(Comparator.reverseOrder());

        StringBuilder sb = new StringBuilder();
        while(N-- > 0){
            int num = Integer.parseInt(br.readLine());

            lower.add(num);
            if(lower.size() - 1 > upper.size()){
                upper.add(lower.poll());
            }

            if(!upper.isEmpty() && lower.peek() > upper.peek()){
                int low = lower.poll();
                int up = upper.poll();
                lower.add(up);
                upper.add(low);
            }

            sb.append(lower.peek()).append('\n');
        }

        System.out.println(sb);
    }
}