| 시간 제한 | 메모리 제한 | 제출 | 정답 | 맞힌 사람 | 정답 비율 |
| --- | --- | --- | --- | --- | --- |
| 0.5 초 (추가 시간 없음) | 512 MB | 7370 | 2962 | 2529 | 40.458% |

## 문제

두 자연수 A와 B가 있을 때, A = BC를 만족하는 자연수 C를 A의 약수라고 한다. 예를 들어, 2의 약수는 1, 2가 있고, 24의 약수는 1, 2, 3, 4, 6, 8, 12, 24가 있다. 자연수 A의 약수의 합은 A의 모든 약수를 더한 값이고, f(A)로 표현한다. x보다 작거나 같은 모든 자연수 y의 f(y)값을 더한 값은 g(x)로 표현한다.

자연수 N이 주어졌을 때, g(N)을 구해보자.

## 입력

첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.

## 출력

첫째 줄에 g(N)를 출력한다.

## 예제 입력 1

```
1

```

## 예제 출력 1

```
1

```

## 예제 입력 2

```
2

```

## 예제 출력 2

```
4

```

## 예제 입력 3

```
10

```

## 예제 출력 3

```
87

```

## 예제 입력 4

```
70

```

## 예제 출력 4

```
4065

```

## 예제 입력 5

```
10000

```

## 예제 출력 5

```
82256014
```

### 문제 풀이
처음 코드

import java.util.Scanner; 

public class Main {
   public static void main (String [] args){
       Scanner sc = new Scanner(System.in);
       
       int num = sc.nextInt();
       int sum = 0;
       
       sc.close();
       for(int i = 1 ; i <= num; i++)
       {
               for(int j = 1; j <= i; j++){
                   if(i % j == 0)
                       sum += j;
               }
       }
       System.out.println(sum);
   }
}
였는데 시간초과라서 생각나는 방법이 없어 검색해본 결과..

약수의 반대 개념인 배수로 풀어라!

N의 배수 = N을 약수로 갖는 수의 집합, 즉 N의 배수를 알면 약수 N을 가진 값들을 알 수 있다.
예를 들어 N이 6일때, 6 까지의 자연수 중에서 1을 약수로 가지는 값의 개수는 6/1 = 6개, 2를 약수로 가지는 값의 개수는 6/2 = 3개 이런식으로 확인 할 수 있다
따라서 N 사이 모든 자연수의 약수의 합은 해당 자연수 * 해당 자연수를 약수로 가지는 값의 개수 들의 합이다. 위의 내용을 통해 코드를 수정하면

import java.util.Scanner; 

public class Main {
   public static void main (String [] args){
       Scanner sc = new Scanner(System.in);
       
       int num = sc.nextInt();
       long sum = 0;
       
       sc.close();
       
       for(int i = 1; i <= num; i++)
       {
           sum += i * (num / i);
       }
       System.out.println(sum);
   }
}