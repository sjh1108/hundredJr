import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int a = s.nextInt(), b = s.nextInt(), c = s.nextInt();

        int benefit = c - b;

        if(benefit <= 0){
            System.out.println(-1);
        } else{
            a /= benefit;
            System.out.println(++a);
        }

        s.close();
    }
}
