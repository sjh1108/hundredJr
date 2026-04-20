import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        s.nextLine();
        
        for(int i = 0; i < n; i++){
            String now = s.nextLine();
            int cnt = 0;
            int count = 0;

            for(int j = 0; j < now.length(); j++){
                char c = now.charAt(j);
                if(c == 'O'){
                    count++;
                    cnt += count;
                } else{
                    count = 0;
                }
            }

            System.out.println(cnt);
        }

        s.close();
    }
}
