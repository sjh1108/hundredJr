import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int idx = 0;
        for(int i = 0; i < n+m; i++){
            int x = Integer.parseInt(br.readLine());

            if(x == 1){
                if(idx++ == s){
                    s *= 2;
                }
            }
            if(x == 0){
                idx--;
            }
        }

        System.out.println(s);
    }
}