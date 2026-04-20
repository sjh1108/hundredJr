import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        s.nextLine();
        String str = s.nextLine();
        int count = 0;
        for(int i = 0; i < n; i++){
            count += str.charAt(i) - '0';
        }
        System.out.println(count);
        s.close();
    }
}
