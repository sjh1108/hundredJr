import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        boolean[] toggle = new boolean[N+1];
        
        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
        }
        sb.append(sum).append('\n');
        
        int q = Integer.parseInt(br.readLine());
        while(q-- > 0){
            st = new StringTokenizer(br.readLine());

            int type = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(type == 2){
				if (!toggle[num]) {
					toggle[num] = true;
					sum -= arr[num];
				} else {
					toggle[num] = false;
					sum += arr[num];
				}
            } else{
                int x = Integer.parseInt(st.nextToken());
				if (toggle[num]) {
					arr[num] = x;
				} else {
					sum -= arr[num];
					arr[num] = x;
					sum += arr[num];
				}
            }

            sb.append(sum).append('\n');
        }

        System.out.println(sb);
    }
}