import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        
        int b = sc.nextInt() / 2;
        b += sc.nextInt();
        
        System.out.print((int)(Math.min(a, b)));
    }
}