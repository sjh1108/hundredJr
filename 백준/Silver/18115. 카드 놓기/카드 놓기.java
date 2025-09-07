import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] str = br.readLine().split(" ");
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 1; i <= N; i++){
            int n = Integer.parseInt(str[N-i]);

            if(n == 1){
                deque.addFirst(i);
            } else if(n == 2){
                int top = deque.pollFirst();
                deque.addFirst(i);
                deque.addFirst(top);
            } else{
                deque.addLast(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!deque.isEmpty()){
            sb.append(deque.pollFirst()).append(" ");
        }
        System.out.println(sb);
    }
}
