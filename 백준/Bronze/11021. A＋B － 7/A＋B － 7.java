import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        
        for(int i = 1; i <= a; i++){
            int x = s.nextInt();
            int y = s.nextInt();
            int k = x+y;
            System.out.println("Case #" + i + ": " + k);
        }

        s.close();
        
    }
}
