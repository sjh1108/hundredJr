import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int p = sc.nextInt();
        int c = sc.nextInt();
        int m = sc.nextInt();
        
        if(m < p * c){
            System.out.println((p * c) - m);
        } else{
            System.out.println(0);
        }
    }
}