import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] dp = new int[31][3];
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(br.readLine());
            HashMap<String, Integer> cloth = new HashMap<>();

            String[] s = new String[n];
            int count = 0;
            for(int c = 0; c < n; c++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String t = st.nextToken();
                if(cloth.get(t) != null){
                    cloth.put(t, cloth.get(t) + 1);
                } else{
                    cloth.put(t, 2);
                    s[count++] = t;
                }
            }
            int r = 1;
            if(count == 1){
                sb.append(cloth.get(s[0]) - 1);
                sb.append('\n');
            } else{
                for(int j = 0; j < count; j++){
                    int k = cloth.get(s[j]);
                    r *= k;
                }
                sb.append(r - 1).append('\n');
            }
        }

        System.out.println(sb);
    }
}