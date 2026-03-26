import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int max = 1;
        int cnt = 0, seq = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        cnt = seq = 1;
        int before = Integer.parseInt(st.nextToken());

        for(int i = 1; i < N; i++){
            int cur = Integer.parseInt(st.nextToken());

            if(cur >= before){
                seq++;
                max = Math.max(max, seq);
            } else{
                cnt++;
                seq = 1;
            }

            before = cur;
        }

        System.out.println(cnt + " " + max);
        
    }
}