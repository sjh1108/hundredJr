import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String MBTI = sc.nextLine();
        
        int n = sc.nextInt();
        int s = 0;
        for(int i = 0; i <= n; i++){
            String st = sc.nextLine();
            if(st.equals(MBTI)) s++;
        }
        
        System.out.println(s);
    }
}