import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;

    static int[] arr;

    public static void main(String[] args) throws IOException{
        char[][] ch = new char[5][15];

        int max = 0;

        for(int i = 0; i < ch.length; i++){
            String s = br.readLine();

            max = Math.max(s.length(), max);

            for(int j = 0; j < s.length(); j++){
                ch[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < max; i++){
            for(int  j = 0; j < 5; j++){
                if(ch[j][i] == '\0') continue;

                sb.append(ch[j][i]);
            }
        }

        System.out.println(sb);
    }
}