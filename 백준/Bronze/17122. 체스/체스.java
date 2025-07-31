import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true;
        boolean[][] arr = new boolean[9][9];
        for(int i = 1; i < 9; i++){
            for(int j = 1; j < 9; j++){
                arr[i][j] = flag;
                flag = !flag;
            }
            flag = !flag;
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int x = Integer.parseInt(st.nextToken());

            
            int n1 = (name.charAt(0) - 'A') + 1;
            int n2 = name.charAt(1) - '0';
            
            boolean nameColor = arr[n2][n1], numColor = true;
            int cnt = 1;
            for(int i = 1; i < 9; i++){
                for(int j = 1; j < 9; j++){
                    if(cnt++ == x){
                        numColor = arr[i][j];
                        break;
                    }
                }
            }

            if(nameColor == numColor){
                sb.append("YES");
            } else{
                sb.append("NO");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}