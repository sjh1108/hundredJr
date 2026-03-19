import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<String>();
        while(N-- > 0){
            st = new StringTokenizer(br.readLine());

            String[] s = new String[2];
            s[0] = st.nextToken();
            s[1] = st.nextToken();
            if(s[1].equals("enter")){
                set.add(s[0]);
            } else{
                set.remove(s[0]);
            }
        }

        ArrayList<String> list = new ArrayList<>(set);
        Collections.sort(list, Collections.reverseOrder());

        for(String li: list){
            sb.append(li).append('\n');
        }
        System.out.println(sb);
    }
}