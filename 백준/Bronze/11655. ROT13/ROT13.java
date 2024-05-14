import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        String s = br.readLine();

        for(int i = 0; i < s.length(); i++){
            char tmp = s.charAt(i);

            if(Character.isUpperCase(tmp)){
                tmp = (char)((tmp - 'A' + 13) % 26 + 'A');
            } else if(Character.isLowerCase(tmp)){
                tmp = (char)((tmp - 'a' + 13) % 26 + 'a');
            }

            sb.append(tmp);
        }
        System.out.println(sb);
    }
}