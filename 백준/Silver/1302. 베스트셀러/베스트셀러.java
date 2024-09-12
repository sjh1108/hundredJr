import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        ArrayList<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < N; i++){
            String name = br.readLine();

            if(map.containsKey(name)){
                map.put(name, map.get(name) + 1);
            } else{
                map.put(name, 1);
                list.add(name);
            }
        }

        Collections.sort(list, (o1, o2)->{
            if(map.get(o1) == map.get(o2)){
                return o1.compareTo(o2);
            } else{
                return map.get(o2) - map.get(o1);
            }
        });

        System.out.println(list.get(0));

    }
}