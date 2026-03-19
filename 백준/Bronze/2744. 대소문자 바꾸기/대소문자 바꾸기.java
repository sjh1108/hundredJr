import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;
    static int[] arr;

    public static void main(String[] args) throws IOException{
        String s = br.readLine();

        int gap = 'a' - 'A';
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c < 'a'){
                c += gap;
            } else{
                c -= gap;
            }
            sb.append(c);
        }
        System.out.println(sb);
    }
}