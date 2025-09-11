import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // int[] arr = new int[N+1];
        // st = new StringTokenizer(br.readLine());
        // for(int i = 1; i <= N; i++){
        //     arr[i] = Integer.parseInt(st.nextToken());
        // }
        br.readLine();

        while(M-- > 0){
            int cmd = Integer.parseInt(br.readLine());

            if(cmd > 0){
                if(cmd < K) continue;

                K = cmd - K + 1;
            } else{
                if(N + cmd + 1 > K) continue;

                K = 2 * N + cmd + 1 - K;
            }
        }

        System.out.println(K);
    }
}