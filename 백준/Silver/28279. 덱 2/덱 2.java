import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        LinkedList<Integer> list = new LinkedList<>();
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());

            switch(cmd){
                case 1:
                    int num = Integer.parseInt(st.nextToken());
                    list.addFirst(num);
                    break;

                case 2:
                    int num2 = Integer.parseInt(st.nextToken());
                    list.addLast(num2);
                    break;

                case 3:
                    if(list.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(list.pollFirst() + "\n");
                    break;

                case 4:
                    if(list.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(list.pollLast() + "\n");
                    break;

                case 5:
                    sb.append(list.size() + "\n");
                    break;

                case 6:
                    if(list.isEmpty()) sb.append(1 + "\n");
                    else sb.append(0 + "\n");
                    break;

                case 7:
                    if(list.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(list.peekFirst() + "\n");
                    break;

                case 8:
                    if(list.isEmpty()) sb.append(-1 + "\n");
                    else sb.append(list.peekLast() + "\n");
            }
        }
        System.out.println(sb);
    }
}