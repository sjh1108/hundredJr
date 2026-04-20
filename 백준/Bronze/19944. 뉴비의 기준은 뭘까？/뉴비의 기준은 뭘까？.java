import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        if(m <= n){
            if(m < 3){
                System.out.println("NEWBIE!");
            } else{
                System.out.println("OLDBIE!");
            }
        } else {
                System.out.println("TLE!");
        }
    }
}