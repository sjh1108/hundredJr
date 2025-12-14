import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0){
            int m = Integer.parseInt(br.readLine());
            sb.append(m/2+1 + "\n");
            Queue<Integer> max = new PriorityQueue<>(Comparator.reverseOrder());
            Queue<Integer> min = new PriorityQueue<>();

            int cnt = 0;
            StringTokenizer st = null;
            for(int i = 0; i < m; i++){
                if(i % 10 == 0){
                    st = new StringTokenizer(br.readLine());
                }

                int x = Integer.parseInt(st.nextToken());

                if(i % 2 == 0){
                    max.add(x);
                } else{
                    min.add(x);
                }
                
                if(!min.isEmpty()){
                    if(max.peek() > min.peek()){
                        int t1 = max.poll();
                        int t2 = min.poll();

                        max.offer(t2);
                        min.offer(t1);
                    }
                }

                if(i % 2 == 0){
                    sb.append(max.peek());
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