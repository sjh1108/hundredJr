import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        while(N-- > 0){
            String target = br.readLine();
            target += target;

            if(target.contains(str)){
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
