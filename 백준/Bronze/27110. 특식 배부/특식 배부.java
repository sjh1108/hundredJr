import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        int sum = (int)(Math.min(a, N) + Math.min(b, N) + Math.min(c, N));
        
        System.out.println(sum);
    }
}