import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        
        int p = 4;
        
        while(N-- > 0){
            int tmp = (int) (Math.sqrt(p));
            tmp = 2 * (tmp - 1) + 1;
            
            p = (int) (Math.pow(tmp, 2));
        }
        
        System.out.println(p);
    }
}