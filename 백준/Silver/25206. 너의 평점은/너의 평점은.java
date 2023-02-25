import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int N;
    static int M;
    static int K;

    static int[] arr;

    public static void main(String[] args) throws IOException{
        double sum = 0d;
        double average = 0d;

        for(int i = 0; i < 20; i++){
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if(gradeCalculator(grade) == -1d){
                continue;
            }
            sum += score;
            average += gradeCalculator(grade) * score;
        }

        System.out.println(average / sum);
    }

    static double gradeCalculator(String grade){
        if(grade.equals("A+")){
            return 4.5d;
        }
        if(grade.equals("A0")){
            return 4.0d;
        }
        if(grade.equals("B+")){
            return 3.5d;
        }
        if(grade.equals("B0")){
            return 3.0d;
        }
        if(grade.equals("C+")){
            return 2.5d;
        }
        if(grade.equals("C0")){
            return 2.0d;
        }
        if(grade.equals("D+")){
            return 1.5d;
        }
        if(grade.equals("D0")){
            return 1.0d;
        }
        if(grade.equals("F")){
            return 0d;
        }

        return -1d;
    }
}