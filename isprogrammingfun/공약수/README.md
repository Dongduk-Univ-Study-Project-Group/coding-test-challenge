| 시간 제한 | 메모리 제한 | 제출 | 정답 | 맞힌 사람 | 정답 비율 |
| --- | --- | --- | --- | --- | --- |
| 1 초 | 256 MB | 7165 | 3372 | 2855 | 51.590% |

## 문제

자연수 n개가 주어진다. 이 자연수의 공약수를 모두 구하는 프로그램을 작성하시오.

## 입력

첫째 줄에 n이 주어진다. n은 2 또는 3이다. 둘째 줄에는 공약수를 구해야 하는 자연수 n개가 주어진다. 모든 자연수는 108 이하이다.

## 출력

입력으로 주어진 n개 수의 공약수를 한 줄에 하나씩 증가하는 순서대로 출력한다.

## 예제 입력 1

```
2
75 125

```

## 예제 출력 1

```
1
5
25

```

## 예제 입력 2

```
3
110 22 88

```

## 예제 출력 2

```
1
2
11
22

```

## 예제 입력 3

```
3
66 11 3

```

## 예제 출력 3

```
1
```

### 문제풀이
빠른 입력을 위해 BufferedReader 를 사용했다. 이를 사용하려면 반드시 throws IOException을 통해 예외처리를 해줘야 한다.
BufferedReader은 버퍼를 사용하여 읽기를 하는 함수이다. 버퍼를 사용하는 입력은, 키보드의 입력이 있을 때마다 한 문자씩 버퍼로 전송한다. 버퍼가 가득 차거나 개행 문자가 나타나면 버퍼의 내용을 한 번에 프로그램에 전달한다. </br>
```
BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 선언
String s = br.readLine();
int i = Integer.parseInt(br.readLine());
```
입력은 readLine(); 이라는 메소드를 사용한다. String으로 리턴 값이 고정되어 있기 때문에, 다름 타입의 입력을 받고자 하면 반드시 형변환이 필요한다. 

```
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(br.readLine());
int N = Integer.parseInt(st.nextToken());
int M = Integer.parseInt(st.nextToken());
```

BufferedReader를 통해 읽어온 데이터는 Line 단위로 나누어진다. 이를 공백 단위로 데이터를 가공하고자 하면 StringTokenizer이나 String.split() 메소드를 통해 가공한다.</br>
StringTokenizer의 nextToken()함수를 사용하면 readLine()을 통해 입력 받은 값을 공백 단위로 구분하여 순서대로 호출할 수 있다.