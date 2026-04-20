import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        s.nextLine();

        for(int i = 0; i < n; i++){
            int k = s.nextInt();
            String str = s.next();

            for(int j = 0; j < str.length(); j++){
                for(int num = 0; num < k; num++){
                    System.out.print(str.charAt(j));
                }
            }
            System.out.println();
        }
        s.close();
    }
}
