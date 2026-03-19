import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        while(N-- > 0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int ans = 1;
            int c = 0;
            if(n % 10 == 0 || n % 10 == 1 || n % 10 == 5 || n % 10 == 6){
                ans = n % 10;
            }
            else if(n % 10 == 4 || n % 10 == 9){
                c = m % 2;
                if(c == 0) c = 2;
            }
            else{
                c = m % 4;
                if(c == 0) c = 4;
            }

            for(int i = 0; i < c; i++){
                ans = (ans * n) % 10;
            }
            if(ans == 0) ans+=10;

            sb.append(ans);
            sb.append('\n');
        }

        System.out.println(sb);
    }
}