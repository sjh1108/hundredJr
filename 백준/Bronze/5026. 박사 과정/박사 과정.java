import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        while(N-- > 0){
            String str = br.readLine();

            if(str.contains("=")){
                sb.append("skipped\n");
                continue;
            }

            String[] n = str.split("\\+");
            sb.append(Integer.parseInt(n[0]) + Integer.parseInt(n[1]))
            .append('\n');
        }
        System.out.println(sb);
    }
}
