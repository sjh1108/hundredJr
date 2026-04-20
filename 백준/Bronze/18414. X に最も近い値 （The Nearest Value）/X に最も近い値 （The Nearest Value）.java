import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        
        int o = c; int gap = Math.abs(a - c);
        for(int i = b; i <= c; i++){
            if(i == a){
                System.out.println(i);
                return;
            }
            
            int ngap = Math.abs(i - a);
            if(ngap <= gap){
                o = i;
                gap = ngap;
            }
        }
        
        System.out.print(o);
    }
}