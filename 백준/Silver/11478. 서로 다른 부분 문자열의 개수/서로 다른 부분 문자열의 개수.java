import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        HashMap<String, Boolean> map = new HashMap<>();
        int count = 0;        

        String s = br.readLine();

        int len = s.length();
        for(int i = 0; i < len - 1; i++){
            for(int j = i + 1; j < len + 1; j++){
                String str = s.substring(i, j);
                if(str == "") continue;
                if(map.get(str) == null){
                    map.put(str, false);
                    count++;
                }
            }
        }
        String str = s.substring(len - 1, len);
        if(map.get(str) == null){
            count++;
        }


        System.out.println(count);
    }
}