import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        Map<Long, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            long tmp = Long.parseLong(br.readLine());

            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }

        int max = -1;
        long max_num = Long.MAX_VALUE;
        for(long l: map.keySet()){
            if(map.get(l) > max){
                max = map.get(l);
                max_num = l;
            } else if(map.get(l) == max){
                max_num = Math.min(l, max_num);
            }
        }

        System.out.println(max_num);
    }
}
