import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> plus = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minus = new PriorityQueue<>();
        while(N-- > 0){
            int tmp = Integer.parseInt(br.readLine());

            if(tmp > 0){
                plus.add(tmp);
            } else{
                minus.add(tmp);
            }
        }

        long res = 0;

        while(!plus.isEmpty()){
            res += plus.peek() * 2;

            int cnt = K;

            while(!plus.isEmpty() && cnt-- > 0){
                plus.poll();
            }
        }

        while(!minus.isEmpty()){
            res -= minus.peek() * 2;

            int cnt = K;

            while(!minus.isEmpty() && cnt-- > 0){
                minus.poll();
            }
        }

        System.out.println(res);
    }
}
