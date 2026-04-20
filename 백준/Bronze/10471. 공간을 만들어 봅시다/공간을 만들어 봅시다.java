import java.io.*;
import java.util.*;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] arg) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        
        boolean[] room = new boolean[w+1];
        List<Integer> list = new ArrayList<>(p+2);
        list.add(0);
        list.add(w);
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < p; i++) {
            int cur = Integer.parseInt(st.nextToken());
            for (int partition : list) {
                room[Math.abs(cur - partition)] = true;
            }
            list.add(cur);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= w; i++) {
            if (room[i])
                sb.append(i).append(' ');
        }
        sb.append(w);

        System.out.println(sb);
    }
}