import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        String s = br.readLine();

        int len = s.length();
        for(int i = len - 1; i >= 0; i--){
            sb.append(s.charAt(i));
        }
        System.out.println(sb);
    }
}