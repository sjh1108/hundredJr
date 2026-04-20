import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        
        int max, min;
        max = s.nextInt();
        min = max;
        for(int i = 1; i < n; i++){
            int a = s.nextInt();
            if(a > max){
                max = a;
            }
            if(a < min){
                min = a;
            }
        }
        System.out.print(min + " " +max);

        s.close();
    }
}
