import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int ans = 1;
        for(int i = 1; i <= a; i++){
            ans *= i;
            ans %= 10;
        }
        System.out.print(ans);
    }
}