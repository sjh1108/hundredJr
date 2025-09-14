import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String key = br.readLine();
        char[] password = new char[26];
        boolean[] used = new boolean[26];

        int passwordIndex = 0;
        for(int i = 0; i < key.length(); i++){
            char c = key.charAt(i);
            if(used[c - 'A']) continue;

            password[passwordIndex++] = c;
            used[c - 'A'] = true;
        }

        int indexCharacter = 0;
        for(int i = passwordIndex; i < 26; i++){
            while(used[indexCharacter]) indexCharacter++;

            password[i] = (char)(indexCharacter++ + 'A');
        }
        
        String str = br.readLine();
        String ans = "";
        for(int i = 0; i < str.length(); i++){
            int idx = str.charAt(i) - 'A';

            ans += password[idx];
        }
        System.out.println(ans);
    }
}