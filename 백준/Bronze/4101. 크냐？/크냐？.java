import java.util.*;

public class Main{
    
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int a, b;
        a = s.nextInt();
        b = s.nextInt();
        
        while(a != 0 && b != 0){
            if(a > b){
                System.out.println("Yes");
            } else{
                System.out.println("No");
            }
            a = s.nextInt();
            b = s.nextInt();
        }
    }
}