import java.util.*;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b;

        for(int i = 0; i < a; i++){
            b = s.nextInt();
            b += s.nextInt();
            System.out.println(b);
        }

        s.close();
    }
}
