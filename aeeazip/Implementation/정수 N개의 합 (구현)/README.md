| 시간 제한 | 메모리 제한 | 제출 | 정답 | 맞힌 사람 | 정답 비율 |
| --- | --- | --- | --- | --- | --- |
| 0.1 초 | 512 MB | 137845 | 68346 | 59079 | 50.418% |

## 문제

정수 n개가 주어졌을 때, n개의 합을 구하는 함수를 작성하시오.

작성해야 하는 함수는 다음과 같다.

- Java: long sum(int[] a); (클래스 이름: Test)
	- a: 합을 구해야 하는 정수 n개가 저장되어 있는 배열 (0 ≤ a[i] ≤ 1,000,000, 1 ≤ n ≤ 3,000,000)
	- 리턴값: a에 포함되어 있는 정수 n개의 합

## 문제풀이

함수만 구현하면 되는 문제이다.

배열의 크기만큼 반복문을 돌리면서 long 타입 ans에 누적합을 더해주고 리턴해주면 된다.

