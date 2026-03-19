import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        long n = 0l;

        st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int type = Integer.parseInt(st.nextToken());

        int len = N.length();
        for(int i = 1; i <= len; i++){
            char c = N.charAt(len - i);
            int num = 0;
            if(c >= 'A' && c <= 'Z'){
                num = c - 'A' + 10;                
            } else{
                num += c - '0';
            }

            n += (long)(Math.pow(type, i - 1) * num);
        }

        System.out.println(n);
    }
}