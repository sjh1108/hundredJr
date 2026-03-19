import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int sum = 0;
        for(int i = 0; i < 8; i++){
            String s = br.readLine();
            
            for(int j = 0; j < 8; j++){
                char c = s.charAt(j);
                if(c == 'F'){
                    if((i + j) % 2 == 0){
                        sum++;
                    }
                }
            }
        }
        
        System.out.println(sum);
    }
}