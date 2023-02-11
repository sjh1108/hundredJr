import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static long K;
    
    static int[][] dp;


    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            
            String s = st.nextToken();

            if(s.equals("push")){
                q.addLast(Integer.parseInt(st.nextToken()));
                continue;
            }

            if(s.equals("pop")){
                if(q.isEmpty()){
                    sb.append(-1);
                } else{
                    sb.append(q.pollFirst());
                }
            }
            
            else if(s.equals("size")){
                sb.append(q.size());
            }

            else if(s.equals("empty")){
                if(q.isEmpty()){
                    sb.append('1');
                } else{
                    sb.append('0');
                }
            } 

            else if(s.equals("front")){
                if(q.isEmpty()){
                    sb.append(-1);
                } else{
                    sb.append(q.getFirst());
                }
            }
            else if(s.equals("back")){
                if(q.isEmpty()){
                    sb.append(-1);
                } else{
                    sb.append(q.getLast());
                }
            }

            sb.append('\n');
        }

        System.out.println(sb);
    }

}