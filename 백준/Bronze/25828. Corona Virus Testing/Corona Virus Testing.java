import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int arr[] = new int[3];
        
        for(int i = 0; i < 3; i++){
            arr[i] = sc.nextInt();
        }
        int a = arr[0] * arr[1];
        int b = arr[0] + arr[1] * arr[2];
        
        int c = 0;
        if(a > b){
            c = 2;
        } else if(a < b){
            c = 1;
        } else{
            c = 0;
        }
        System.out.println(c);
    }
}