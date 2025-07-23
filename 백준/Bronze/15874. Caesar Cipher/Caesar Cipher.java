import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k =  Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            int tmp = 0;
            if(!Character.isAlphabetic(c)) {
                sb.append(c);
                continue;
            } else if(Character.isLowerCase(c)){
                tmp = (((c - 'a') + k) % 26) + 'a';
                c = (char) tmp;
            } else{
                tmp = (((c - 'A') + k) % 26) + 'A';
                c = (char) tmp;
            }

            sb.append(c);
        }
        System.out.println(sb);
    }
}