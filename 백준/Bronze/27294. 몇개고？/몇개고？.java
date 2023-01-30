import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int time = s.nextInt();
        int alc = s.nextInt();
        
        s.close();
        
        boolean bab = true;
        
        if(alc == 1){
            bab = false;
        }
        if(time < 12 || time > 16){
            bab = false;
        }
        
        if(bab){
            System.out.print(320);
        } else{
            System.out.print(280);
        }
    }
}