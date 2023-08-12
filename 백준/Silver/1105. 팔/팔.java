import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;

    public static void main(String[] args) throws IOException{
        st = new StringTokenizer(br.readLine());

        String s1 = st.nextToken();
        String s2 = st.nextToken();

        if(s1.length() != s2.length()){
            System.out.println(0);
            return;
        }

        int cnt = 0;
        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i) == s2.charAt(i)){
                if(s1.charAt(i) == '8'){
                    cnt++;
                }
            } else{
                break;
            }
        }
        System.out.println(cnt);
    }
}