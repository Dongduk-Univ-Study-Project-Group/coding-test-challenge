## 문제 설명
    
총 N개의 문자열로 이루어진 집합 S가 주어진다. 
입력으로 주어지는 M개의 문자열 중에서 집합 S에 포함되어 있는 것이 총 몇 개인지 구하는 프로그램을 작성하시오.

## 입력

- 첫째 줄에 문자열의 개수 N과 M (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 10,000)이 주어진다. 
- 다음 N개의 줄에는 집합 S에 포함되어 있는 문자열들이 주어진다.
- 다음 M개의 줄에는 검사해야 하는 문자열들이 주어진다.
- 입력으로 주어지는 문자열은 알파벳 소문자로만 이루어져 있으며, 길이는 500을 넘지 않는다. 집합 S에 같은 문자열이 여러 번 주어지는 경우는 없다.

## 출력

첫째 줄에 M개의 문자열 중에 총 몇 개가 집합 S에 포함되어 있는지 출력한다.

## 예제 입력 1

'5 11
baekjoononlinejudge
startlink
codeplus
sundaycoding
codingsh
baekjoon
codeplus
codeminus
startlink
starlink
sundaycoding
codingsh
codinghs
sondaycoding
startrink
icerink'

### 예제 입력 설명

- 5개의 문자열로 이루어진 집합 S = {baekjoononlinejudge, startlink, codeplus, sundaycoding, codingsh}
- 검사해야 하는 문자열 11개는 baekjoon부터 icerlink까지

## 예제 출력 1

'4'

### 예제 출력 설명

- 문자열 11개 중 집합 S에 해당하는 것은 codeplus, startlink, sundaycoding, codingsh 이므로 4개

## 시간 제한

- Java 8: 6 초
- Java 8 (OpenJDK): 6 초
- Java 11: 6 초
- Kotlin (JVM): 6 초

## 풀이 설명

- 배열 사용
- 두 문자열이 서로 같다면 길이도 같다는 것을 이용
- 검사해야 하는 문자열과 집합 S의 문자열의 길이가 서로 같은지 먼저 확인
- 길이가 같을 때만 equals 메소드 호출하여 집합 포함 여부 판별

## 메모
- 통과하긴 했으나, 이중 for문 사용과 배열 전체를 탐색해야 하는 등 비효율적인 풀이(시간 5276ms)
- HashMap으로 Key 값을 이용한 탐색이 바람직함(시간 408ms)
- String[] a가 아닌 더 적절한 배열 이름이 없을지 
