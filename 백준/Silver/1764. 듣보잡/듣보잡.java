import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Boolean> map = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int count = 0;
        String[] s = new String[N];
        for(int i = 0; i < N; i++){
            map.put(br.readLine(), false);
        } for(int i = 0; i < M; i++){
            String str = br.readLine();
            if(map.get(str) != null){
                s[count] = str;
                count++;
            }
        }
        s = Arrays.copyOf(s, count);
        Arrays.sort(s);
        sb.append(count).append('\n');
        for(int i = 0; i < count; i++){
            sb.append(s[i]).append('\n');
        }
        System.out.println(sb);
    }
}