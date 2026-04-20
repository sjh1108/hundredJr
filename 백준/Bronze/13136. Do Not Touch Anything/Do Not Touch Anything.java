import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong(), b = sc.nextLong(), c = sc.nextLong();
        
        long x = (a / c) + ((a % c == 0) ? 0 : 1);
        long y = (b / c) + ((b % c == 0) ? 0 : 1);
        
        System.out.println(x * y);
    }
}