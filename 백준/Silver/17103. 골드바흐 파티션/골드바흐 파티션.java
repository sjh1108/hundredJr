import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        boolean[] num = new boolean[10000001];
        num[0] = num[1] = true;
        for (int i = 2; i * i <= 10000000; i++) {
            if (!num[i]) {
                for (int j = i + i; j <= 10000000; j += i) {
                    num[j] = true;
                }
            }
        }

        while (t-- > 0) {
            int temp = Integer.parseInt(br.readLine());
            int ans = 0;
            for (int j = 2; j <= temp / 2; j++) {
                if (!num[j] && !num[temp - j]) ans++;
            }
            System.out.println(ans);
        }
    }

}