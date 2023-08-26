import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    public static void main(String[] args) throws IOException{
        String s = null;

        while((s = br.readLine()) != null){
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }

}