#include <stdio.h>
#include <string.h>
// [baekjoon] 11557번 - Yangjojang of The Year

int main() {

	int T, N, L[100];
	char S[100][21];					// 학교 이름을 저장할 2차원 배열!
	scanf("%d", &T);			

	for (int i = 0; i < T; i++) {
		scanf("%d", &N);
		int max_num = 0;				// 술 소비가 가장 많은 학교의 순서
		int max_sul = 0;				// 술 소비가 가장 많은 학교의 술 소비량
		
		for (int j = 0; j < N; j++) {
			scanf("%s%d", &S[j], &L[j]);
			if (L[j] > max_sul) {		// 술 소비량 비교
				max_sul = L[j];
				max_num = j;
			}
		}
		printf("%s\n", S[max_num]);
	}

}