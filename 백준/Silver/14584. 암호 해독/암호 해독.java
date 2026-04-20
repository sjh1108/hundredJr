import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] origin = br.readLine().toLowerCase().toCharArray();
        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        while(N-- > 0){
            list.add(br.readLine());
        }

        for(int c = 0; c < 26; c++){
            for(int i = 0; i < origin.length; i++){
                origin[i] = (char)((origin[i] - 'a' + 1) % 26 + 'a');
            }

            String decode = String.valueOf(origin);
            for(String s: list){
                if(decode.contains(s)){
                    System.out.println(decode);
                    return;
                }
            }
        }
    }
}