import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(N-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            int cmd = st.nextToken().charAt(0) == 'C' ? 0 : 1;

            st = new StringTokenizer(br.readLine());
            if(cmd == 0){
                for(int i = 0; i < cnt; i++){
                    sb.append(st.nextToken().charAt(0) - 'A' + 1).append(" ");
                }
            } else{
                for(int i = 0; i < cnt; i++){
                    sb.append((char)(Integer.parseInt(st.nextToken()) + 'A' - 1)).append(" ");
                }
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}