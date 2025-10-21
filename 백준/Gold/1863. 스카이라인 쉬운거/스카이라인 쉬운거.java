import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        stack.push(0);
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            // int a = Integer.parseInt(st.nextToken());
            st.nextToken();
            int b = Integer.parseInt(st.nextToken());

            int top = stack.peek();

            while(b < top){
                stack.pop();
                top = stack.peek();
                cnt++;
            }
            if(top < b){
                stack.push(b);
            }
        }

        while(!stack.isEmpty()){
            stack.pop();
            ++cnt;
        }
        --cnt;

        System.out.println(cnt);
    }
}