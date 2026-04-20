import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        
        int N = s.nextInt();
        // 0: tanbattle 1: tanprice 2: dilbattle 3: dilprice
        double[] ls = new double[4];
        for(int i = 0; i < 4; i++){
            ls[i] = s.nextInt();
        }

        // 최대 전투력
        int max = 0;
        int tm = 0, dm = 0;


        if(N < ls[1] && N < ls[3]){
            tm = 0;
            dm = 0;
            System.out.println(tm + " " + dm);
            System.exit(0);
        }
        // 탱커 수 별 전투력
        double[] tanker = new double[(int) (N / ls[1] + 1)];
        for(int i = 0; i < tanker.length; i++){
            // 탱커 사면 나오는 전투력
            tanker[i] = i * ls[0];

            // 남은 돈
            int money = (int) (N - ls[1] * i);

            // 남은 돈으로 구매 가능한 딜러 수
            int count = money / (int) ls[3];

            // 딜러 전투력 합산
            tanker[i] += count * ls[2];

            // 전투력 비교
            if(max < tanker[i]){
                max = (int) (tanker[i]);
                tm = i;
                dm = count;
            }
        }
        System.out.println(tm + " " + dm);


        s.close();
    }
}
