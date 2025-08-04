import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] c = br.readLine().toCharArray();
        int length = c.length;

        int[] arr = new int[length];
        for(int i = 0; i < length; i++){
            arr[i] = c[i] - '0';
        }
        int[] sum = new int[length+1];
        for(int i = 0; i < length; i++){
            sum[i+1] = sum[i] + arr[i];
        }

        int max = 0;
        for(int i = 1; i < length; i++){
            int l = i-1;
            int r = i+1;

            while(l >= 0 && r <= length){
                int leftSum = sum[i] - sum[l];
                int rightSum = sum[r] - sum[i];

                if(leftSum == rightSum){
                    max = Math.max(max, r-l);
                }
                l--; r++;
            }
        }

        System.out.println(max);
    }
}
