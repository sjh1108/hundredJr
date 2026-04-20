import java.util.*;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    
    public static void main(String[] args) throws IOException {


        for(int tmp = 0; tmp < 4; tmp++){
            Line x1, x2, y1, y2;

            st = new StringTokenizer(br.readLine());
            int[] arr = new int[4];
            for(int i = 0; i < 4; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            x1 = new Line(arr[0], arr[2]);
            y1 = new Line(arr[1], arr[3]);
            for(int i = 0; i < 4; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            x2 = new Line(arr[0], arr[2]);
            y2 = new Line(arr[1], arr[3]);

            int ix = inter(x1, x2), iy = inter(y1, y2); 

            sb.append(sq(ix, iy)).append("\n");
        }

        System.out.println(sb);
    }

    static class Line{
        int s, e;

        public Line(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
    static int inter(Line a, Line b) {
        if (a.s > b.s) {
          Line tmp = a;
          a = b;
          b = tmp;
        }
        if (a.e < b.s) return 0;
        else if (a.e == b.s) return 1;
        else return 2;
    }

    static char sq(int ix, int iy){
        char ans = 'd';
        if(ix == 2 && iy == 2) ans = 'a';
        else if((ix == 1 && iy == 2) || (ix == 2 && iy == 1)) ans = 'b';
        else if(ix == 1 && iy == 1) ans = 'c';

        return ans;
    }
}
