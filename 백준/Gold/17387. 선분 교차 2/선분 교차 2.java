import java.io.*;
import java.util.*;

public class Main{
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    static int N, M, K;
    
    static class Point{
        long x, y;
        Point(long x, long y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{
        Point[] arr = new Point[4];

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

        // 두 직선이 일직선 상에 있음
		if (p123 * p124 == 0 && p341 * p342 == 0) {
			is_result = true;


            boolean compare1 = Math.min(p[0].x, p[1].x) <= Math.max(p[2].x, p[3].x);
            boolean compare2 = Math.min(p[2].x, p[3].x) <= Math.max(p[0].x, p[1].x);
            boolean compare3 = Math.min(p[0].y, p[1].y) <= Math.max(p[2].y, p[3].y);
            boolean compare4 = Math.min(p[2].y, p[3].y) <= Math.max(p[0].y, p[1].y);
            // 두 선이 겹침
			if (compare1 && compare2 && compare3 && compare4)
				result = 1;
		}

        // 두 직선이 일직선 상에 없으나, 한 점이 겹치는 경우를 고려하기 위해 <= 0으로 체크함
		if (p123 * p124 <= 0 && p341 * p342 <= 0) {
            // 일직선 상이 아니라면
			if (!is_result)
				result = 1;
		}
        
		return result;
	}

    public static int ccw(Point p1, Point p2, Point p3){
        long result = ((p1.x * p2.y) + (p2.x * p3.y) + (p3.x * p1.y)) - ((p1.y * p2.x) + (p2.y * p3.x) + (p3.y * p1.x));

        // 반시계
		if (result > 0)
			return 1;
        // 일직선
		else if (result == 0)
			return 0;
        // 시계
		else
			return -1;
    }
}