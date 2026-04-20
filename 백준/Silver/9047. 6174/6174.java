import java.io.*;
import java.util.*;

class Main {
    private static final int TARGET = 6174;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0){
            int num = Integer.parseInt(br.readLine());
            int ans = 0;

            while(num != TARGET){
                int[] digit = new int[4];
                for(int i = 0; i < 4; i++){
                    digit[i] = num % 10;
                    num /= 10;
                }

                Arrays.sort(digit);

                int min = 0;
                int max = 0;

                for(int i = 0; i < 4; i++){
                    min = min * 10 + digit[i];
                    max = max * 10 + digit[3-i];
                }

                num = max - min;
                ans++;
            }
            sb.append(ans);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}