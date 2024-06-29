import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        
        Set<String> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            String str = br.readLine();

            set.add(str);

            sb = new StringBuilder(str);
            String reverse = sb.reverse().toString();

            if(set.contains(reverse)){
                System.out.println(str.length() + " " + str.charAt(str.length() / 2));
                return;
            }
        }
    }
}