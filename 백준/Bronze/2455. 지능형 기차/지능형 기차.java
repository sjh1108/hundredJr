import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int sum = 0, max = 0;
        int a = 0, b = 0;
        
        for(int i = 0; i < 4; i++){
            a = sc.nextInt(); b = sc.nextInt();
            
            sum = sum + b - a;
            
            max = Math.max(max, sum);
        }
        
        
        System.out.print(max);
    }
}