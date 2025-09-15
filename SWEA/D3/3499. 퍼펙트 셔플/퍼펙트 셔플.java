import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            String ans = "";
            ArrayDeque<String> dq1 = new ArrayDeque<>();
            ArrayDeque<String> dq2 = new ArrayDeque<>();
            for(int i = 0; i < (N / 2)  + (N%2); i++){
                dq1.add(st.nextToken());
            }while(st.hasMoreTokens()){
                dq2.add(st.nextToken());
            }

            while(!dq2.isEmpty()){
                ans += dq1.poll();
                ans += " ";
                ans += dq2.poll();
                ans += ' ';
            }
            if(!dq1.isEmpty()) ans += dq1.poll();

            System.out.println("#" + t + " " + ans);
        }
    }
}