import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        String str = s.nextLine();

        char prev = str.charAt(0);
        int count = 1;
        if(str.length() <= 1){
            count = 1;
            System.out.println(count);
            System.exit(0);
        }
        for(int i = 1; i < str.length(); i++){
            if(str.charAt(i) == prev){
                count++;
                continue;
            } else{
                break;
            }
        }
        System.out.println(count);

        s.close();
    }
}
