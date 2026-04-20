import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long L = 0;
        long R = 2025;

        for(int i = 0; i < 9; i++){
            if(L==R) break;

            long mid = L + (R-L) / 2;
            System.out.println("? " + mid);
            System.out.flush();

            String response = br.readLine();

            if (response.equals("SUAPC!")) {
                // 정답을 찾았을 경우
                L = mid;
                R = mid;
                break;
            } else if (response.equals("Hot")) {
                // 샤워기 물(mid)이 더 뜨거웠을 경우
                // 이전 체온 T_old는 [L, mid-1] 범위에 있었음
                // 새로운 체온 T_new의 범위를 계산하여 업데이트
                long newR = Math.floorDiv(mid + (mid - 1), 2);
                long newL = Math.floorDiv(mid + L, 2);
                L = newL;
                R = newR;
            } else { // "Cold"
                // 샤워기 물(mid)이 더 차가웠을 경우
                // 이전 체온 T_old는 [mid+1, R] 범위에 있었음
                // 새로운 체온 T_new의 범위를 계산하여 업데이트
                long newL = Math.floorDiv(mid + (mid + 1), 2);
                long newR = Math.floorDiv(mid + R, 2);
                L = newL;
                R = newR;
            }
        }

        System.out.println("! " + L);
        System.out.flush();
    }
}