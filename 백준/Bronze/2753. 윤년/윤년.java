import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        boolean b = false;
        if(a % 4 == 0){
            if(a % 100 == 0){
                if(a % 400 == 0){
                    b = true;
                } else{ 
                    b = false;
                }
            } else{
                b = true;
            }
        }
        if(b){
            System.out.print(1);
        } else{
            System.out.println(0);
        }
        s.close();
    }
}
