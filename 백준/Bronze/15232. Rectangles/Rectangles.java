import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        for(int i = 0; i < a; i++){
            for(int j = 0; j < b; j++){
                sb.append('*');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}