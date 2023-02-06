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
        K = Integer.parseInt(br.readLine());

        while(K-- > 0){
            String p = br.readLine();
            int size = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), ",");

            LinkedList<Integer> deck = new LinkedList<>();
            for(int i = 0; i < size; i++){
                String token = st.nextToken();

                if(i == 0){
                    token = token.replace("[", "");
                }
                if(i == size - 1){
                    token = token.replace("]", "");
                }

                deck.offerLast(Integer.parseInt(token));
            }

            boolean isForward = true;
            boolean isErrored = false;

            for(int i = 0; i < p.length(); i++){
                char operator = p.charAt(i);
                if(operator == 'R'){
                    isForward = !isForward;
                } else{

                    if(deck.size() < 1){
                        isErrored = true;
                        break;
                    }

                    if(isForward){
                        deck.pollFirst();
                    } else{
                        deck.pollLast();
                    }
                }
            }

            if(isErrored){
                sb.append("error");
            } else{
                sb.append('[');

                int tmp = 0;
                size = deck.size();
                if(isForward){
                    for(int i = 0; i < size; i++){
                        tmp = deck.pollFirst();
                        sb.append(tmp);

                        if(i < size - 1){
                            sb.append(',');
                        }
                    }
                } else{
                    for(int i = 0; i < size; i++){
                        tmp = deck.pollLast();
                        sb.append(tmp);

                        if(i < size - 1){
                            sb.append(',');
                        }
                    }
                }

                sb.append(']');
            }

            sb.append('\n');
        }
        System.out.println(sb);
    }
}