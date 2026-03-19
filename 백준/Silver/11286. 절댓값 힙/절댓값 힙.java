import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new
    // OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        ArrayList<Integer> p = new ArrayList<>();
        ArrayList<Integer> m = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                int A = Math.abs(a);
                int B = Math.abs(b);
                if(A > B){
                    return A - B;
                } else if(A == B){
                    if(a > b) return 1;
                    else return -1;
                } else{
                    return -1;
                }
            }
        });

        while(N-- > 0){
            int x = Integer.parseInt(br.readLine());

            if(x == 0){
                if(!pq.isEmpty()){
                    sb.append(pq.poll());
                } else{
                    sb.append(0);
                }
                sb.append('\n');
            } else{
                pq.offer(x);
            }
        }

        System.out.println(sb);
    }
}