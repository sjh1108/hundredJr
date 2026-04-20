import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        boolean[] st = new boolean[31];
        for(int i = 0; i < 28; i++){
            int a = s.nextInt();
            st[a] = true;
        }

        for(int i = 1; i < 31; i++){
            if(st[i] == true){
                continue;
            } else{
                System.out.println(i);
            }
        }

        s.close();
    }
}
