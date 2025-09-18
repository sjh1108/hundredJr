import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int l = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        for(int i = l; i <= r; i++){
            set.add(i | x);
        }
        for(int i = 0; i <= (r | x) + 1; i++){
            if(!set.contains(i)){
                System.out.println(i);
                return;
            }
        }
    }
}