import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int burger = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++){
            int a = sc.nextInt();
            if(burger > a){
                burger = a;
            }
        }
        int drink = Integer.MAX_VALUE;
        for(int i = 0; i < 2; i++){
            int a = sc.nextInt();
            if(drink > a){
                drink = a;
            }
        }
        int sum = drink + burger - 50;
        
        System.out.println(sum);
    }
}