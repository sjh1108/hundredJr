import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static List<Integer> sol(List<Integer> arr1, List<Integer> arr2) {
        List<Integer> res = new ArrayList<>();

        // 두 배열 중 하나라도 비어 있으면 결과 반환
        if (arr1.isEmpty() || arr2.isEmpty()) {
            return res;
        }

        // arr1과 arr2에서 각각 가장 큰 값과 그 인덱스를 찾음
        int tmp1 = Collections.max(arr1);
        int tmp2 = Collections.max(arr2);
        int idx1 = arr1.indexOf(tmp1);
        int idx2 = arr2.indexOf(tmp2);

        // 두 값이 같으면 결과에 추가하고 그 이후 부분으로 재귀 호출
        if (tmp1 == tmp2) {
            res.add(tmp1);
            arr1.subList(0, idx1 + 1).clear(); // arr1에서 값 제거
            arr2.subList(0, idx2 + 1).clear(); // arr2에서 값 제거
            res.addAll(sol(arr1, arr2));
        } else if (tmp1 > tmp2) {
            arr1.remove(idx1); // tmp1이 더 크면 arr1에서 제거
            res.addAll(sol(arr1, arr2));
        } else {
            arr2.remove(idx2); // tmp2가 더 크면 arr2에서 제거
            res.addAll(sol(arr1, arr2));
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        List<Integer> arr1 = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr1.add(scanner.nextInt());
        }
        
        int m = scanner.nextInt();
        List<Integer> arr2 = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            arr2.add(scanner.nextInt());
        }

        // 함수 호출
        List<Integer> ans = sol(arr1, arr2);

        // 결과 출력
        System.out.println(ans.size());
        if (!ans.isEmpty()) {
            for (int num : ans) {
                System.out.print(num + " ");
            }
        }
    }
}
