import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while(T-- > 0){
            int N = Integer.parseInt(br.readLine());
            int sum = 0;
            
            st = new StringTokenizer(br.readLine());
            while(N-- > 0){
                sum += Integer.parseInt(st.nextToken());
            }
            
            System.out.println(sum);
        }
        
    }
}