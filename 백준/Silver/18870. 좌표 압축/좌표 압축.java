import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        int[] sor = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sor[i] = arr[i];
        }

        Arrays.sort(sor);
        int count = 0;
        for(int v : sor){
            if(!map.containsKey(v)){
                map.put(v, count);
                count++;
            }
        }
        for(int key: arr){
            sb.append(map.get(key)).append(' ');
        }
        
        System.out.println(sb);
    }
}