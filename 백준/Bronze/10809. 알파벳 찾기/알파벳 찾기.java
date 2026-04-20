import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        
        int[] alp = new int[26];
        for(int i = 0; i < alp.length; i++){
            alp[i] = -1;
        }

        String str = s.nextLine();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            int a = (c - 'a');

            if(alp[a] == -1){
                alp[a] = i;
            }

        }

        for(int val : alp){
            System.out.print(val + " ");
        }

        s.close();
    }
}
