import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] narr = new int[M];
        HashMap<Integer, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int a = Integer.parseInt(st.nextToken());
            narr[i] = a;
            map.put(a, 0);
        }
        for(int i = 0; i < N; i++){
            if(map.get(arr[i]) == null) continue;
            map.put(arr[i], 1);
        }
        for(int i = 0; i < M; i++){
            int time = map.get(narr[i]);
            sb.append(time).append(' ');
        }


        System.out.println(sb);
    }
}