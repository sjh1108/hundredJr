import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int ans = 0;

        while(true){
            int cnt = 0;
            int tmp = N;

            while(tmp != 0){
                if(tmp % 2 == 1) cnt++;

                tmp /= 2;
            }

            if(cnt <= M) break;
            N++;
            ans++;
        }
        System.out.println(ans);
    }
}