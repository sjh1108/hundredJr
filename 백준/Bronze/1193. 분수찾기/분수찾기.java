import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int num = s.nextInt();
        int min = 1, max = 1, count = 1;

        int x = 1, y = 1;

        while(true){
            if((num >= min) && (num <= max)){
                if(count % 2 == 0){
                    x = num - min + 1;
                    y = count - x + 1;
                } else{
                    y = num - min + 1;
                    x = count - y + 1;
                }
                break;
            } else{
                min = max + 1;
                max = min + count;
                count++;
            }
        }

        System.out.println(x + "/" + y);


        s.close();
    }
}
