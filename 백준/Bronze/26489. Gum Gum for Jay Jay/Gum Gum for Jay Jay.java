import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 0;
        
        while(true){
            if(br.readLine() == null) break;
            cnt++;
        }
        System.out.println(cnt);
    }
}