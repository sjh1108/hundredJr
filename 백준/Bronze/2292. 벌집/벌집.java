import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int num = s.nextInt();
        int min = 1, max = 1, count = 1;

        while(true){
            if((num >= min) && (num <= max)){
                break;
            } else{
                min = max;
                max = min++ + (count * 6);
                count++;
            }
        }

        System.out.println(count);


        s.close();
    }
}
