import java.util.*;
import java.io.*;

class Main{
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String str = br.readLine();

            int len = str.length();
            if(len > 10) continue;

            int numeric = 0;
            int lower = 0;
            int upper = 0;

            for(int j = 0; j < len; j++){
                char c = str.charAt(j);

                if(Character.isDigit(c)) numeric++;
                if(Character.isLowerCase(c)) lower++;
                if(Character.isUpperCase(c)) upper++;
            }

            if(numeric == len) continue;
            if(lower >= upper){
                System.out.println(str);
                break;
            }
        }

    }
}