import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int get = s.nextInt();
        int[] arr = new int[get];
        for(int i = 0; i < get; i++){
            arr[i] = s.nextInt();
        }
        int v = s.nextInt();
        int count = 0;
        for(int i = 0; i < get; i++){
            if(arr[i] == v){
                count++;
            }
        }
        System.out.println(count);

        s.close();
    }
}
