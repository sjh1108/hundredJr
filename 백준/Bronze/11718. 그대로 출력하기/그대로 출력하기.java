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
        while(true){
            String s = br.readLine();

            if(s == null || s.isEmpty()){
                break;
            }
            sb.append(s);
            sb.append('\n');
        }

        System.out.println(sb);
    }
}