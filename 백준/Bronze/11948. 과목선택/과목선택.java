import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int sum = 0;
        int min = 101;
        for(int i = 0; i < 4; i++){
            int a = sc.nextInt();
            sum += a;
            min = Math.min(a, min);
        }
        
        sum -= min;
        min = 101;
        for(int i = 0; i < 2; i++){
            int a = sc.nextInt();
            sum += a;
            min = Math.min(a, min);
        }
        sum -= min;
        
        System.out.print(sum);
    }
}