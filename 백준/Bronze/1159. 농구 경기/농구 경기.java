import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        int[] falpha = new int[26];
        for(int i = 0; i < N; i++){
            String str = br.readLine();
            falpha[str.charAt(0) - 'a']++;
        }

        boolean flag = false;
        for(int i = 0; i < 26; i++){
            if(falpha[i] >= 5){
                sb.append((char)(i + 'a'));
                flag = true;
            }
        }

        if(!flag) sb.append("PREDAJA");
        System.out.println(sb);
    }
}