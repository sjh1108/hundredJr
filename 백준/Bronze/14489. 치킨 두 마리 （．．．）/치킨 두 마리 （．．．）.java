import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        long a = sc.nextLong();
        long b = sc.nextLong();
        
        long c = sc.nextLong();
        
        if( a + b < 2 * c){
            System.out.println(a + b);
        } else{
            System.out.println(a + b - (2 * c));
        }
    }
}