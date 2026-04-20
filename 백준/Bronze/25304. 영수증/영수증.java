import java.util.*;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();

        int count = 0;
        for(int i = 0; i < b; i++){
            int c = s.nextInt();
            int n = s.nextInt();
            count += c*n;
        }
        if(a == count){
            System.out.println("Yes");
        } else{
            System.out.println("No");
        }
        //System.out.println(b);

        s.close();
    }
}
