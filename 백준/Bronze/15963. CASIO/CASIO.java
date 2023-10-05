import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        if(a.equals(sc.next())) System.out.print(1);
        else System.out.print(0);
    }
}