import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        int day = 0;
        int[] month = {3, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        String[] dayOfWeek = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < m; i++){
            day += month[i];
        }
        day += d;

        System.out.println(dayOfWeek[day % 7]);
    }
}