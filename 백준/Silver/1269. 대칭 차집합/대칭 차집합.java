import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<Integer, Boolean> map = new HashMap<>();
        HashMap<Integer, Boolean> map2 = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int count = 0;

        int acount = N, bcount = M;

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(st.nextToken());
            map.put(a, false);
            arr[i] = a;
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int a = Integer.parseInt(st.nextToken());
            map2.put(a, false);
            if(map.get(a) != null){
                acount--;
            }
        }
        for(int i = 0; i < N; i++){
            if(map2.get(arr[i]) != null){
                bcount--;
            }
        }
        count = acount + bcount;


        System.out.println(count);
    }
}