import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        double[] arr = new double[n];
        double max = 0;

        double avg = 0;

        for(int i = 0; i < n; i++){
            arr[i] = s.nextInt();
            if(arr[i] > max){
                max = arr[i];
            }
        }
        for(int i = 0; i < n; i++){
            arr[i] = (arr[i] / max) * 100;
            avg += arr[i];
        }
        avg = avg / n;

        System.out.println(avg);
        s.close();
    }
}
