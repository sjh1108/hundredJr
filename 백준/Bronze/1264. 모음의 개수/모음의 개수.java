import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        String s = br.readLine();

        while(!s.equals("#")){
            s = s.toLowerCase();
            int cnt = 0;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);

                if(c == 'a' || c == 'e' || c == 'o' || c == 'i' || c == 'u'){
                    cnt++;
                }
            }

            sb.append(cnt).append('\n');

            s = br.readLine();
        }

        System.out.println(sb);
    }
}