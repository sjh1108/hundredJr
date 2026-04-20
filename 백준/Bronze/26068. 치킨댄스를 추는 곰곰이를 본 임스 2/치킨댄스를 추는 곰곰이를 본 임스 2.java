import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), "-");
            st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            if(a <= 90) sum++;
        }
        
        System.out.println(sum);
    }
}