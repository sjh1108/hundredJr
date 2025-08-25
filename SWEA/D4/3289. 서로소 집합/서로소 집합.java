import java.util.*;

public class Solution {
    private static int N, M;

    private static int[] arr;

    private static void union(int a, int b){
        int rootA = find(a);
        int rootB = find(b);
        arr[rootA] = rootB;
    }

    private static int find(int x){
        if(arr[x] == x) return x;
        return arr[x] = find(arr[x]);
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 1; t <= T; t++){
            System.out.print("#" + t + " ");
            N = sc.nextInt();
            M = sc.nextInt();

            arr = new int[N+1];
            for(int i = 1; i <= N; i++){
                arr[i] = i;
            }

            for(int i = 0; i < M; i++){
                int cmd = sc.nextInt();

                int a = sc.nextInt();
                int b = sc.nextInt();

                if(cmd == 0){
                    union(a, b);
                } else{
                    int rootA = find(a);
                    int rootB = find(b);

                    System.out.print(rootA == rootB ? 1 : 0);
                }
            }

            System.out.println();
        }

        sc.close();
    }
}
