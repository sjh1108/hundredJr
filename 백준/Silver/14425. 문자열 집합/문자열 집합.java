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

        String str;
        for(int i = 0; i < N; i++){
            map.put(br.readLine(), false);
        }
        for(int i = 0; i < M; i++){
            str = br.readLine();
            if(map.get(str) != null){
                count++;
            }
        }


        System.out.println(count);
    }
}