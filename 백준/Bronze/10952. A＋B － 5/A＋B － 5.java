import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        //int a = s.nextInt();
        
        while(true){
            int x = s.nextInt();
            int y = s.nextInt();
            x += y;
            if(x == 0 && y == 0){
                break;
            } else{
                System.out.println(x);
            }
        }

        s.close();
        
    }
}
