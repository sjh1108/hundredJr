import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N, M, K;

    public static void main(String[] args) throws IOException {
        String s = br.readLine();

        while(Integer.parseInt(s) != 0){

            int add = 2;
            int len = s.length();
            add += len - 1;
            
            for(int i = 0; i < len; i++){
                char c = s.charAt(i);

                if(c == '0'){
                    add += 4;
                } else if(c == '1'){
                    add += 2;
                } else{
                    add += 3;
                }
            }

            sb.append(add).append('\n');

            s = br.readLine();
        }

        System.out.println(sb);
    }

}