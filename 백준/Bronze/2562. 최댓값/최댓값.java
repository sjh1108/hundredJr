import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int max = s.nextInt();
        int lin = 1;
        for(int i = 1; i < 9; i++){
            int a = s.nextInt();
            if(a > max){
                max = a;
                lin = i + 1;
            }
        }
        System.out.print(max + "\n" + lin);

        s.close();
    }
}
