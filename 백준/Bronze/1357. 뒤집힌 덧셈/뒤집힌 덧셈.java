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
        
        System.out.println(rev(rev(N) + rev(M)));
    }

    static int rev(int x){
        int ret = 0;
        while(x > 0){
            ret *= 10;
            ret += x % 10;
            x /= 10;
        }

        return ret;
    }
}