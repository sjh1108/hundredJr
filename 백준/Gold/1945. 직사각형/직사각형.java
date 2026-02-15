import java.io.*;
import java.util.*;

class Main {
    static class Point {
        int x, y;
        int type; 

        public Point(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }

    private static int N;

    private static ArrayList<Point> points = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            points.add(new Point(x1, y2, 1));
            points.add(new Point(x2, y1, -1));
        }

        Collections.sort(points, new Comparator<Point>() {
            @Override
            public int compare(Point a, Point b) {
                double gradA = (double) a.y / a.x;
                double gradB = (double) b.y / b.x;

                if (gradA == gradB) {
                    return Integer.compare(b.type, a.type);
                }
                
                return Double.compare(gradB, gradA);
            }
        });

        System.out.println(sweeping());
    }

    private static int sweeping() {
        int ret = 0, cnt = 0;
        for (Point p : points) {
            ret = Math.max(ret, cnt);
            cnt += p.type;
        }
        return ret;
    }
}