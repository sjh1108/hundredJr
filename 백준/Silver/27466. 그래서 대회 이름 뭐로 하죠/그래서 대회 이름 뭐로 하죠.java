import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 문자열 길이
		int m = Integer.parseInt(st.nextToken()); // 운영진이 원하는 길이
		char[] arr = br.readLine().toCharArray(); // 문자열
		
		// A의 인덱스를 저장하는 리스트
		List<Integer> aindexs = new LinkedList<>();
		for (int i = 0 ; i < n - 1; i++) {
			if (arr[i] == 'A') {
				aindexs.add(i);
			}
		}
		
		// A는 무조건 2개 이상이 필요하지만 2개 미만으로 있을때
		if (aindexs.size() < 2) {
			sb.append("NO");
		} else {
			// 뒤에서 2, 3번째는 A라면 맨 뒷자리 하나를 제외하면 무조건 앞쪽에 있는 문자열을 제거하거나 사용해야 되기 때문에
			int subm = m - 3;
			
			if (aindexs.get(aindexs.size() - 2) < subm) { // 앞 쪽에 문자열이 부족할 경우
				sb.append("NO");
			} else {
				for (int i = aindexs.get(aindexs.size() - 2) - subm; i < aindexs.get(aindexs.size() - 2); i++) {
					sb.append(arr[i]);
				}
				
				// 뒤에서 1, 2번째 A와 A사이는 전부 제거한다.
				sb.append("AA");
				
				// 조건에 맞는 단어가 들어오면 추가한다.
				for (int i = aindexs.get(aindexs.size() - 1) + 1; i < arr.length; i++) {
					if (arr[i] != 'A' && arr[i] != 'E' && arr[i] != 'I' && arr[i] != 'O' && arr[i] != 'U') {
						sb.append(arr[i]);
						break;
					}
				}
				
				// 마지막에 추가가 되지 않는다면 다시 NO를 입력
				if (sb.length() != m) {
					sb = new StringBuilder();
					sb.append("NO");
				}
			}
		}
		
		bw.write(sb.toString().equals("NO") ? sb.toString() : "YES\n" + sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
