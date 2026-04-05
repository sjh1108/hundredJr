import java.io.*;
import java.util.*;

class Main {

    private static int N, K;
    
    private static int[] arr;
    private static HashSet<Integer> set;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        set = new HashSet<>();

        dfs(0, "", 0);

        System.out.println(set.size());
    }

    private static void dfs(int cnt, String key, int bit){
        if(cnt == K){
            set.add(Integer.parseInt(key));
            return;
        }

        for(int i = 0; i < N; i++){
            if((bit & (1 << i)) != 0) continue;

            dfs(cnt+1, key + String.valueOf(arr[i]), bit | (1<<i));
        }
    }
}