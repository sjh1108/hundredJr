import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        HashSet<String> map = new HashSet<>();
        
        int rbow = 0;
        String s1, s2;
        StringTokenizer st;
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            
            s1 = st.nextToken();
            s2 = st.nextToken();
            
            if(s1.equals("ChongChong") || s2.equals("ChongChong")){
                map.add(s1);
                map.add(s2);
                rbow += 2;
                break;
            }
        }
        while(n-- > 0){
            st = new StringTokenizer(br.readLine());
            
            s1 = st.nextToken();
            s2 = st.nextToken();
            
            if(map.contains(s1)){
                if(!map.contains(s2)){
                    map.add(s2);
                    rbow++;
                }
            }
            
            else if(map.contains(s2)){
                if(!map.contains(s1)){
                    map.add(s1);
                    rbow++;
                }
            }
        }
        
        System.out.println(rbow);
    }
}