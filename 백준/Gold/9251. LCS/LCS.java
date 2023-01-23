import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int N;
    static int M;

    static Integer[] f;
    static int[][] arr;

    public static void main(String[] args) throws IOException{
        String a = br.readLine();
        String b = br.readLine();

        M = 0;
        func(a, b);

        System.out.println(M);
    }

    static void func(String a, String b){
        int len1 = a.length();
        int len2 = b.length();

        arr = new int[len1 + 1][len2 + 1];

        for(int i = 1; i < len1 + 1; i++){
            for(int j = 1; j < len2 + 1; j++){
                int m = Math.max(i, j);

                if(a.charAt(i - 1) == b.charAt(j - 1)){
                    arr[i][j] = Math.min(m, arr[i - 1][j - 1] + 1);
                } else{
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }

        M = arr[len1][len2];
    }
}