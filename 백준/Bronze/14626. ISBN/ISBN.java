import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int damageIndex = 0;
        int sum = 0;
        for(int i = 0; i < 13; i++){
            char c = s.charAt(i);

            if(c == '*'){
                damageIndex = i % 2 == 0 ? 1 : 3;
                continue;
            }

            int tmp = c - '0';
            tmp *= i % 2 == 0 ? 1 : 3;
            sum += tmp;
        }
        
        for(int i = 0; i < 10; i++){
            int tmp = damageIndex * i;

            if((sum+tmp) % 10 == 0){
                System.out.println(i);
                return;
            }
        }
    }
}