import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 8; i++){
            int a = sc.nextInt();
            if(a == 9){
                System.out.print("F");
                return;
            }
        }
        
        System.out.print("S");
   }
}