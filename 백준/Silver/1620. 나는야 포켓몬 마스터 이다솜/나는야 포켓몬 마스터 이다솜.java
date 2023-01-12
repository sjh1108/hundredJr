import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String str;
        for(int i = 0; i < N; i++){
            str = br.readLine();
            map.put(str, i + 1);
            map2.put(i + 1, str);
        }
        for(int i = 0; i < M; i++){
            str = br.readLine();
            try{
                int a = Integer.parseInt(str);
                sb.append(map2.get(a));
            } catch (NumberFormatException e){
                sb.append(map.get(str));
            } finally{
                sb.append('\n');
            }
        }

        System.out.println(sb);
    }
}