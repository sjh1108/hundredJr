import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> map = new HashSet<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0;
        
        List<String> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            map.add(br.readLine());
        }
        for(int i = 0; i < M; i++){
            String str = br.readLine();
            if(map.contains(str)){
                list.add(str);
            }
        }
        
        Collections.sort(list);
        sb.append(list.size()).append('\n');
        for(String s: list){
            sb.append(s).append('\n');
        }
        System.out.println(sb);
    }
}