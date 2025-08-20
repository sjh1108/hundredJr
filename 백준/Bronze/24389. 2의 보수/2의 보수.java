import java.util.*;

public class Main{
    public static void main(String[] args){
        int n = new Scanner(System.in).nextInt();
        int m = ~n + 1;
        n ^= m;
        
        int count = 0;
        for (char ch : Integer.toBinaryString(n).toCharArray()){
            if(ch == '1'){
                count++;
            }
        }

        System.out.print(count);
    }
}