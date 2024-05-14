import java.util.*;
import java.io.*;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int N, M;

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine(), "*");
        String s = st.nextToken(); int slen = s.length();
        String e = st.nextToken(); int elen = e.length();
        for(int t = 0; t < T; t++){
            boolean flag = true;

            String tmp = br.readLine();
            if(tmp.length() < slen + elen){
                sb.append("NE\n");
                continue;
            }

            
            for(int i = 0; i < slen && flag; i++){
                if(s.charAt(i) != tmp.charAt(i)){
                    flag = false;
                }
            }

            for(int i = 0; i < elen && flag; i++){
                if(e.charAt(i) != tmp.charAt(tmp.length() - elen + i)){
                    flag = false;
                }
            }

            if(flag){
                sb.append("DA\n");
            }else{
                sb.append("NE\n");
            }
        }
        System.out.println(sb);
    }
}