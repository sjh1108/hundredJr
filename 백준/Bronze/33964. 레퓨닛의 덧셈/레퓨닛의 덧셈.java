import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        if(n < m){
            int tmp = n;
            n = m;
            m = tmp;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(i < n - m){
                sb.append(1);
            } else{
                sb.append(2);
            }
        }
        
        System.out.print(sb.toString());
    }
}