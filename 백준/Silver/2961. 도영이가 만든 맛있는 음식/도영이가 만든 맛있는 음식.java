import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());

        int[] acid = new int[N];
        int[] bitter = new int[N];
        
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            acid[i] = Integer.parseInt(st.nextToken());
            bitter[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i < (1 << N); i++){

            int a = 1;
            int b = 0;

            for(int j = 0; j < N; j++){
                if((i & (1 << j)) != 0){
                    a *= acid[j];
                    b += bitter[j];
                }
            }

            min = Math.min(min, Math.abs(a-b));
        }

        System.out.println(min);
    }
}