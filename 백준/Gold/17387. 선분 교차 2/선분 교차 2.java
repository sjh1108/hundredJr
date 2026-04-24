import java.io.*;
import java.util.*;

class Main{
    static class Point{
        long x, y;
        Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Point[] arr = new Point[4];

        StringTokenizer st;
        for(int i = 0; i < 4; i+=2){
            st = new StringTokenizer(br.readLine());
            arr[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
            arr[i+1] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        System.out.println(checkCCW(arr));
    }

    public static int checkCCW(Point[] p) {
		boolean is_result = false;
		int result = 0;
		int p123 = ccw(p[0], p[1], p[2]);
		int p124 = ccw(p[0], p[1], p[3]);
		int p341 = ccw(p[2], p[3], p[0]);
		int p342 = ccw(p[2], p[3], p[1]);

		if (p123 * p124 == 0 && p341 * p342 == 0) {
			is_result = true;


            boolean compare1 = Math.min(p[0].x, p[1].x) <= Math.max(p[2].x, p[3].x);
            boolean compare2 = Math.min(p[2].x, p[3].x) <= Math.max(p[0].x, p[1].x);
            boolean compare3 = Math.min(p[0].y, p[1].y) <= Math.max(p[2].y, p[3].y);
            boolean compare4 = Math.min(p[2].y, p[3].y) <= Math.max(p[0].y, p[1].y);
			if (compare1 && compare2 && compare3 && compare4)
				result = 1;
		}

		if (p123 * p124 <= 0 && p341 * p342 <= 0) {
			if (!is_result)
				result = 1;
		}
        
		return result;
	}

    private static int ccw(Point p1, Point p2, Point p3){
        long result = ((p1.x * p2.y) + (p2.x * p3.y) + (p3.x * p1.y)) - ((p1.y * p2.x) + (p2.y * p3.x) + (p3.y * p1.x));

		if (result > 0)
			return 1;
		else if (result == 0)
			return 0;
		else
			return -1;
    }
}