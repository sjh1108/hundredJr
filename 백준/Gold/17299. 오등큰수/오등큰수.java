import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    static int[] arr;
    static int[] NGF;
    static Map<Integer, Integer> map = new HashMap<>();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        NGF = new int[N];
        Arrays.fill(NGF, -1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            } else{
                map.put(arr[i], 1);
            }
        }

        for(int i = 0; i < N; i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }

            if(map.get(arr[stack.peek()]) < map.get(arr[i])){
                while(!stack.isEmpty()
                && map.get(arr[stack.peek()]) < map.get(arr[i])){
                    NGF[stack.pop()] = arr[i];
                }
            }

            stack.push(i);
        }

        for(int i = 0; i < N; i++){
            sb.append(NGF[i]).append(" ");
        }
        System.out.println(sb);
    }
}