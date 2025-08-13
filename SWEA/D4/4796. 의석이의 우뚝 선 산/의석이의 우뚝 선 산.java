import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;
 
class Solution
{
    private static int N;
    private static int[] height;

    private static List<Integer> mt;

    public static void main(String args[]) throws Exception
    {
		//System.setIn(new FileInputStream("res/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        StringBuilder sb = new StringBuilder();
        for(int test_case = 1; test_case <= T; test_case++)
        {
            sb.append("#").append(test_case).append(" ");

            N = sc.nextInt();
            height = new int[N];

            for(int i = 0; i < N; i++){
                height[i] = sc.nextInt();
            }

            mt = new ArrayList<>();
            for(int i = 1; i < N-1; i++){
                if(height[i] > height[i-1] && height[i] > height[i+1]){
                    mt.add(i);
                }
            }

            int cnt = 0;
            for(int idx : mt){
                int tmp = idx;
                int lCnt = 0;
                while(height[tmp] > height[tmp-1]){
                    lCnt++;
                    tmp--;
                    if(tmp == 0) break;
                }

                tmp = idx;
                int rCnt = 0;
                while(height[tmp] > height[tmp+1]){
                    rCnt++;
                    tmp++;
                    if(tmp == N-1) break;
                }

                cnt += lCnt * rCnt;
            }

            sb.append(cnt);
            sb.append("\n");
        }
 
        System.out.println(sb.toString());
    }
}