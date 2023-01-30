import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static long K;
    
    static int[] arr;
    static int[] f;
    static boolean[] brr;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        Stack<Integer> stk = new Stack<>();
        arr = new int[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            if(s.equals("push")){
                stk.push(Integer.parseInt(st.nextToken()));
            }
            else if(s.equals("pop")){
                if(stk.isEmpty()){
                    sb.append(-1);
                    sb.append('\n');
                } else{
                    int tmp = stk.pop();
                    sb.append(tmp);
                    sb.append('\n');
                }
            }
            else if(s.equals("size")){
                sb.append(stk.size());
                sb.append('\n');
            }
            else if(s.equals("empty")){
                if(stk.empty()){
                    sb.append(1);
                } else{
                    sb.append(0);
                }
                sb.append('\n');
            }
            else if(s.equals("top")){
                if(stk.isEmpty()){
                    sb.append(-1);
                } else{
                    sb.append(stk.peek());
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}