import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        while(a-- > 0){
            if(sc.nextInt() < sc.nextInt())
                System.out.println("NO BRAINS");
            else
                System.out.println("MMM BRAINS");
        }
    }
}