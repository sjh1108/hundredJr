import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        
        if(b >= 45){
            b-=45;
            System.out.println(a + " " + b);
        }else if(a>0 && b < 45){
            int m = 45 - b;
            b = 60 - m;
            a--;
            System.out.println(a + " " + b);
        } else{
            int m = 45 - b;
            b = 60 - m;
            System.out.println(23 + " " + b);
        }
        s.close();
    }
}
