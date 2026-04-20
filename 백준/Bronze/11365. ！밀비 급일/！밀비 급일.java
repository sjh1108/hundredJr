import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    
    public static void main(String[] args) throws IOException {
        String s = br.readLine();

        while(!s.equals("END")){
            for(int i = s.length() - 1; i >= 0; i--){
                sb.append(s.charAt(i));
            } sb.append("\n");

            s = br.readLine();
        }

        System.out.println(sb);
    }
}
