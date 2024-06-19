import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        int len = N / 2;

        int cnt = 0;
        String str = br.readLine();
        for(int i = 0; i < len; i++){
            if(str.charAt(i) != str.charAt(N-1 - i)){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}