import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N, M;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int cnt = 0;
        for(int i = 0; i < 5; i++){
            M = Integer.parseInt(st.nextToken());
            if(M == N) cnt++;
        }
        System.out.println(cnt);
    }
}