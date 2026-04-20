import java.util.*;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();

        boolean ab = (a == b);
        boolean ac = (a == c);
        boolean bc = (b == c);

        int prize = 0;
        if(ab && bc && ac){
            prize = 10000;
            prize += a * 1000;
        } else if(ab || bc || ac){
            prize = 1000;
            if(ab || ac){
                prize += a * 100;
            } else{
                prize += b * 100;
            }
        } else{
            int m = 0;
            m = Math.max(Math.max(a, b), c);
            prize = m * 100;
        }

        System.out.println(prize);
        s.close();
    }
}
