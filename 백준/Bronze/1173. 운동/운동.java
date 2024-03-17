import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int min = m;
        int cnt = 0;

        if(M - m < T){
            System.out.println(-1);
            return;
        } else{
            while(true){
                if((m + T)<= M){
                    m += T;
                    N--;
                } else{
                    m -= R;
                }

                if(m < min){
                    m = min;
                }
                cnt++;

                if(N == 0) break;
            }
            System.out.println(cnt);
        }
    }
}