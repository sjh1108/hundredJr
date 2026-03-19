import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int get = s.nextInt();
        int a, b, c, count = 0;

        a = get / 10;
        b = get % 10;
        
        while(true){
            c = a + b;
            if(((a * 10 + b) == get) && count != 0){
                System.out.println(count);
                break;
            }
            a = b;
            b = c % 10;
            count++;
        }

        s.close();
        
    }
}
