import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int h = sc.nextInt();
        h = (int)(Math.max(h, n - h));
        int v = sc.nextInt();
        v = (int)(Math.max(v, n - v));
        
        System.out.println(h * v * 4);
    }
}