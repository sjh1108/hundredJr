import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        String str = s.nextLine().trim();
        String[] arr = str.split(" ");

        if(str.length() == 0){
            System.out.println("0");
        } else{
            System.out.println(arr.length);
        }
        

        s.close();
    }
}
