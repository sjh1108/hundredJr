import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int cnt = 1;
        for(int i = 0; i < N; i++){
            if(arr[i] == cnt){
                cnt++;
                while(!stack.isEmpty() && stack.peek() == cnt){
                    stack.pop();
                    cnt++;
                }
            } else{
                stack.push(arr[i]);
            }
        }
        if(cnt == N + 1){
            System.out.println("Nice");
        } else{
            System.out.println("Sad");
        }
    }
}
