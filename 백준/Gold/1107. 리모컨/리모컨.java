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
        M = Integer.parseInt(br.readLine());
        if(M > 0) st = new StringTokenizer(br.readLine());
        
        boolean[] button = new boolean[10];
        while(M-- > 0){
            button[Integer.parseInt(st.nextToken())] = true;
        }

        int cnt = Math.abs(100 - N);
        if(M == 10){
            System.out.println(cnt);
            System.exit(0);
        }

        for(int i = 0; i <= 999999; i++){
            if(i > N * 10 && cnt < N - 100) break;
            boolean chk = true;

            String s = String.valueOf(i);

            for(int j = 0; j < s.length(); j++){
                if(button[s.charAt(j) - '0']){
                    chk = false;
                    break;
                }
            }

            if(!chk) continue;

            cnt = (int)(Math.min(cnt, s.length() + Math.abs(N - i)));
        }

        System.out.println(cnt);
    }
}