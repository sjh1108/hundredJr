import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int ny = Integer.parseInt(st.nextToken());
        int nm = Integer.parseInt(st.nextToken());
        int nd = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int ey = Integer.parseInt(st.nextToken());
        int em = Integer.parseInt(st.nextToken());
        int ed = Integer.parseInt(st.nextToken());

        if(ny + 1000 < ey 
            || (ny + 1000 == ey && nm < em)
            || (ny + 1000 == ey && nm == em && nd <= ed)){
                System.out.println("gg");
                return;
        }

        int day = 0;
        for(int i = ny + 1; i < ey; i++){
            if(i % 4 == 0 && i % 100 != 0 || i % 400 == 0){
                day += 366;
            }else{
                day += 365;
            }
        }

        int[] monthDay = {31, 28, 31, 30, 31, 30, 31, 31, 30 ,31, 30, 31};
        if(ny == ey){
            if(nm == em){
                day = day + ed - nd;
            } else{
                for(int i = nm + 1; i < em; i++){
                    day = day + monthDay[i];
                }

                if((ny % 4 == 0 && ny % 100 != 0 || ny % 400 == 0) && 
                    (nm <= 2 || em >= 3)){
                    day += day + 1;
                }

                day += monthDay[nm - 1] - nd  + ed;
            }
        } else{
            for(int i = 0; i < em - 1; i++){
                day += monthDay[i];
            }

            for(int i = nm; i < 12; i++){
                day += monthDay[i];
            }

            if((ny % 4 == 0 && ny % 100 != 0 || ny % 400 == 0) && nm <= 2){
                day += 1;
            }

            if((ey % 4 == 0 && ey % 100 != 0 || ey % 400 == 0) && em >= 3){
                day += 1;
            }

            day += monthDay[nm - 1] - nd + ed;
        }

        System.out.println("D-" + day);
    }   
}
