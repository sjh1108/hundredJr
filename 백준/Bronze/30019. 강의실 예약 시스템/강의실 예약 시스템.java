import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        StringBuilder sb = new StringBuilder();
        while(m-- > 0){
            st = new StringTokenizer(br.readLine());

            int k = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if(arr[k] <= s){
                arr[k] = e;
                sb.append("YES\n");
            } else{
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }
}
