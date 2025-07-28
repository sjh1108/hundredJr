import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] height = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 1; i <= n; i++){
            height[i] = Integer.parseInt(st.nextToken());
            stack.push(i);
        }

        int before = Integer.MAX_VALUE;
        int[] result = new int[n+1];
        Stack<Integer> popped = new Stack<>();

        while(!stack.isEmpty()){
            // 맨 뒤에서부터 탐색
            // cur: 탐색하고자 하는 탑의 index
            int cur = stack.pop();
            int curHeight = height[cur];

            // 현재 pop 된 탑이 이전 탑보다 낮은 경우 popped stack에 push
            if(curHeight < before){
                popped.push(cur);
            }
            // 이전 탑보다 높거나 같은 경우
            else{
                // popped 스택이 비거나, 현재 pop된 탑보다 큰 탑이 pop될 경우까지 반복
                while(!popped.isEmpty()){
                    int popIndex = popped.pop();
                    int popHeight = height[popIndex];

                    if(curHeight > popHeight){
                        result[popIndex] = cur;
                    }
                    else{
                        before = curHeight;
                        popped.push(popIndex);
                        break;
                    }
                }

                popped.push(cur);
            }
            
            before = curHeight;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < n+1; i++){
            sb.append(result[i] + " ");
        }
        System.out.println(sb);
    }
}