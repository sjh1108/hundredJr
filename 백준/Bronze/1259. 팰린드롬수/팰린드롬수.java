//import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        while(true){
            String s = br.readLine();
            if(Integer.parseInt(s) == 0){
                break;
            }
            boolean yes = true;
            for(int i = 0; i < (s.length() / 2) + 1; i++){
                if(s.charAt(i) != s.charAt(s.length() - (i + 1))){
                    yes = false;
                }
            }
            if(yes){
                sb.append("yes").append('\n');
            } else{
                sb.append("no").append('\n');
            }
        }
        System.out.println(sb);
    }
}