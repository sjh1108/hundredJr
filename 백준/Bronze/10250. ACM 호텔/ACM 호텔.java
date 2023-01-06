import java.util.*;


public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();

        for(int i = 0; i < n; i++){
            calculate(s);
        }

        s.close();
    }

    static void calculate(Scanner s){
        int h = s.nextInt();
        int w = s.nextInt();
        int n = s.nextInt();

        int a = n % h;
        int b = (n / h);
        if(n % h == 0){
            a = h;
        }
        if(n % h != 0){
            b++;
        }
        a = a*100 + b;

        System.out.println(a);
    }
}
