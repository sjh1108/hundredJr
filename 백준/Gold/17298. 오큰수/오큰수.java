import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    static int[] arr;
    static int[] NGE;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        NGE = new int[N];
        Arrays.fill(NGE, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }

            if(arr[stack.peek()] < arr[i]){
                while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                    NGE[stack.pop()] = arr[i];
                }
            }
            stack.push(i);
        }

        for(int i: NGE){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}