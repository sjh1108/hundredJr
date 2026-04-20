import java.util.Scanner;
 
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        a *= 100;
        int b = sc.nextInt();
        
        if(a - b >= 0){
            System.out.print("Yes");
        } else{
            System.out.print("No");
        }
    }
}