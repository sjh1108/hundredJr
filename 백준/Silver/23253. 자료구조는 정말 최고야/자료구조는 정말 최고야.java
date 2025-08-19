import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean result = true;

        loop: for(int i = 0; i < M; i++){
            int n = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());
            int prev = Integer.MAX_VALUE;
            for(int j = 0; j < n; j++){
                int tmp = Integer.parseInt(st.nextToken());
                
                if(tmp > prev) {
                    result = false;
                    break loop;
                }

                prev = tmp;
            }
        }

        if(result) {
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }
    }
}