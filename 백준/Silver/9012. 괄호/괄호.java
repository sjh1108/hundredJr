import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static long K;
    
    static int[] arr;
    static int[] f;
    static boolean[] brr;
    static int[][] dp;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            String s = br.readLine();

            int tmp = 0;
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == '('){
                    tmp++;
                } else{
                    tmp--;
                }
                if(tmp < 0){
                    break;
                }
            }

            if(tmp == 0){
                sb.append("YES");
            } else{
                sb.append("NO");
            }
            sb.append('\n');
        }

        System.out.println(sb);

    }
}