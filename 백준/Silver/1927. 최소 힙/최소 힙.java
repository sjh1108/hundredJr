import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;

    static int[] arr;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();        
        while(N-- > 0){
            int tmp = Integer.parseInt(br.readLine());

            if(tmp != 0){
                q.add(tmp);
            } else{
                if(q.isEmpty()){
                    sb.append(0);
                }
                else{
                    int min = q.poll();

                    sb.append(min);
                }

                sb.append('\n');
            }
        }

        System.out.println(sb);
    }
}