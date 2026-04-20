import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        s.nextLine();
        
        int cnt = 0;
        for(int i = 0; i < n; i++){
            String word = s.nextLine();
            if(word.length() <= 2){
                cnt++;
                continue;
            }
            boolean[] alp = new boolean[26];
            boolean pass = true;

            char prev = word.charAt(0);
            for(int j = 1; j < word.length(); j++){
                char c = word.charAt(j);
                if(c != prev){
                    alp[prev - 'a'] = true;
                    if(alp[c - 'a']){
                        pass = false;
                        break;
                    } else{
                        prev = c;
                    }
                }
            }
            
            if(pass){
                cnt++;
            }
        }
        System.out.println(cnt);

        s.close();
    }
}
