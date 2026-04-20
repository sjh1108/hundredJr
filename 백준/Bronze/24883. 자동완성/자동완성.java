import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char c = sc.nextLine().charAt(0);
        if(c == 'n' || c == 'N')
            System.out.print("Naver D2");
        else
            System.out.print("Naver Whale");
    }
}