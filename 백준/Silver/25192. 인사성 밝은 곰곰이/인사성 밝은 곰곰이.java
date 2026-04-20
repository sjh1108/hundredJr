import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        HashSet<String> map = new HashSet<>();
        
        int size = 0;
        while(n-- > 0){
            String s = br.readLine();
            
            if(s.equals("ENTER")){
                map = new HashSet<>();
                continue;
            }
            if(!map.contains(s)){
                map.add(s);
                size++;
            }
            
        }
        
        System.out.println(size);
    }
}