import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        
        for(int line = 0; line < n; line++){
            int i;
            int num = s.nextInt();
            int[] arr = new int[num];
            double avg = 0;
            for(i = 0; i < num; i++){
                arr[i] = s.nextInt();
                avg += arr[i];
            }
            avg /= num;

            double cnt = 0;
            for(i = 0; i < num; i++){
                if(arr[i] > avg){
                    cnt++;
                }
            }
            cnt = cnt * 100 / num;
            System.out.printf("%.3f%%\n", cnt);
        }

        s.close();
    }
}
