import java.io.*;
import java.util.*;

class Main {
    static class Point{
        double x1, y1;
        double x2, y2;

        public Point(double x1, double y1, double x2, double y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }
    }
    private static final int INF = 5000;

    private static int N;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        parent = new int[N];
        Point[] points = new Point[N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            parent[i] = i;

            st = new StringTokenizer(br.readLine());
            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());

            points[i] = new Point(x1, y1, x2, y2);
        }

        for(int i = 0; i < N; i++){
			for(int j = 0; j < N; j++){
				Point p1 = points[i];
                Point p2 = points[j];

                double res = intersectionPointX(p1, p2);

				if (res == INF + 1) {
					if (p1.x2 - p1.x1 == 0 && p2.x2 - p2.x1 == 0) {
						if (p1.x1 != p2.x1) {
							continue;
						}

						if ((p1.y1 > p2.y1 && p1.y1 > p2.y2 && p1.y2 > p2.y1 && p1.y2 > p2.y2)
								|| (p2.y1 > p1.y1 && p2.y1 > p1.y2 && p2.y2 > p1.y1 && p2.y2 > p1.y2)) {
							continue;
						}

						union(i, j);
						continue;
					}

					double m1 = (p1.y2 - p1.y1) / (p1.x2 - p1.x1);
					double m2 = (p2.y2 - p2.y1) / (p2.x2 - p2.x1);

					double n1 = -m1 * p1.x1 + p1.y1;
					double n2 = -m2 * p2.x1 + p2.y1;

					if (n1 != n2) {
						continue;
					}

					if ((p1.x1 > p2.x1 && p1.x1 > p2.x2 && p1.x2 > p2.x1 && p1.x2 > p2.x2)
							|| (p2.x1 > p1.x2 && p2.x1 > p1.x2 && p2.x2 > p1.x1 && p2.x2 > p1.x2)) {
						continue;
					}

					if ((p1.y1 > p2.y1 && p1.y1 > p2.y2 && p1.y2 > p2.y1 && p1.y2 > p2.y2)
							|| (p2.y1 > p1.y1 && p2.y1 > p1.y2 && p2.y2 > p1.y1 && p2.y2 > p1.y2)) {
						continue;
					}

					union(i, j);
				}
				else {
					if (res >= Math.min(p1.x1, p1.x2) && res <= Math.max(p1.x1, p1.x2) && res >= Math.min(p2.x1, p2.x2)
							&& res <= Math.max(p2.x1, p2.x2)) {
						res = intersectionPointY(p1, p2);

						if (res <= INF && res >= -INF) {
							if (res >= Math.min(p1.y1, p1.y2) && res <= Math.max(p1.y1, p1.y2)
									&& res >= Math.min(p2.y1, p2.y2) && res <= Math.max(p2.y1, p2.y2)) {
								union(i, j);
							}
						}
					}
				}
            }
        }

        int[] cnt = new int[N];
        for (int i = 0; i < N; i++) {
            cnt[find(i)]++;
        }

        int groupCnt = 0;
        int lineCnt = 0;

        for (int i = 0; i < N; i++) {
            if (cnt[i] > 0) {
                groupCnt++;
            }

            lineCnt = Math.max(lineCnt, cnt[i]);
        }
        
        System.out.println(groupCnt + "\n" + lineCnt);
    }

	private static int find(int x) {
		if (x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}

	private static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			if (x < y)  parent[y] = x;
			else        parent[x] = y;
		}
	}

    private static double intersectionPointX(Point p1, Point p2){
		if ((p1.x1 - p1.x2) * (p2.y1 - p2.y2) - (p1.y1 - p1.y2) * (p2.x1 - p2.x2) == 0) {
			return INF + 1;
		}

		double denominator = ((p1.x1 * p1.y2 - p1.y1 * p1.x2) * (p2.x1 - p2.x2))
				- ((p1.x1 - p1.x2) * (p2.x1 * p2.y2 - p2.y1 * p2.x2));
		double numerator = ((p1.x1 - p1.x2) * (p2.y1 - p2.y2)) - ((p1.y1 - p1.y2) * (p2.x1 - p2.x2));

		return denominator / numerator;
    }

	private static double intersectionPointY(Point l1, Point l2) {
		if ((l1.x1 - l1.x2) * (l2.y1 - l2.y2) - (l1.y1 - l1.y2) * (l2.x1 - l2.x2) == 0) {
			return INF + 1;
		}

		double denominator = ((l1.x1 * l1.y2 - l1.y1 * l1.x2) * (l2.y1 - l2.y2)
				- (l1.y1 - l1.y2) * (l2.x1 * l2.y2 - l2.y1 * l2.x2));
		double numerator = ((l1.x1 - l1.x2) * (l2.y1 - l2.y2) - (l1.y1 - l1.y2) * (l2.x1 - l2.x2));

		return denominator / numerator;
	}
}