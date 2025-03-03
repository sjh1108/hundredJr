import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Character, Character> map = new HashMap<>();
        map.put('b', 'd');
        map.put('d', 'b');
        map.put('p', 'q');
        map.put('q', 'p');

        map.put('i', 'i');
        map.put('o', 'o');
        map.put('v', 'v');
        map.put('w', 'w');
        map.put('x', 'x');

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        outLoop: while(!s.equals("#")){
            StringBuilder tmp = new StringBuilder();

            for(int i = s.length()-1; i >= 0; i--){
                if(map.containsKey(s.charAt(i))){
                    tmp.append(map.get(s.charAt(i)));
                } else{
                    sb.append("INVALID");
                    sb.append("\n");

                    s = br.readLine();
                    continue outLoop;
                }
            }
            
            sb.append(tmp).append('\n');
            s = br.readLine();
        }

        System.out.println(sb.toString());
    }
}