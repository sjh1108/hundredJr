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

        LinkedList<Integer> d = new LinkedList<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();

            if(s.equals("push_front")){
                d.offerFirst(Integer.parseInt(st.nextToken()));
            }

            else if(s.equals("push_back")){
                d.offerLast(Integer.parseInt(st.nextToken()));
            }

            else if(s.equals("pop_front")){
                if(d.size() == 0){
                    sb.append(-1).append('\n');
                    continue;
                }
                int tmp = d.pollFirst();

                sb.append(tmp).append('\n');
            }

            else if(s.equals("pop_back")){
                if(d.size() == 0){
                    sb.append(-1).append('\n');
                    continue;
                }
                int tmp = d.pollLast();

                sb.append(tmp).append('\n');
            }

            else if(s.equals("size")){
                sb.append(d.size()).append('\n');
            }

            else if(s.equals("empty")){
                if(d.size() == 0){
                    sb.append(1);
                } else{
                    sb.append(0);
                }
                sb.append('\n');
            }

            else if(s.equals("front")){
                if(d.size() < 1){
                    sb.append(-1);
                } else{
                    sb.append(d.getFirst());
                }
                sb.append('\n');
            }

            else if(s.equals("back")){
                if(d.size() < 1){
                    sb.append(-1);
                } else{
                    sb.append(d.getLast());
                }
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }
}