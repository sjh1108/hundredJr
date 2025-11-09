import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(m != 0){
            char[] array = br.readLine().toCharArray();

            int max = 0;
            int left = 0;
            int len = array.length;
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < len; i++){
                char c = array[i];

                if(map.containsKey(c)){
                    map.put(c, map.get(c) + 1);
                } else{
                    map.put(c, 1);
                }

                while(map.size() > m){
                    char l = array[left++];

                    map.put(l, map.get(l)-1);
                    if(map.get(l) == 0) map.remove(l);
                }
                
                max = Math.max(max, i-left + 1);
            }

            sb.append(max).append('\n');
            m = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }
}