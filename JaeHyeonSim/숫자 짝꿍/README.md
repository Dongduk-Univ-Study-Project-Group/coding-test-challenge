
### **문제 설명**

두 정수 `X`, `Y`의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다(단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다). `X`, `Y`의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. `X`, `Y`의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.

예를 들어, `X` = 3403이고 `Y` = 13203이라면, `X`와 `Y`의 짝꿍은 `X`와 `Y`에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다. 다른 예시로 `X` = 5525이고 `Y` = 1255이면 `X`와 `Y`의 짝꿍은 `X`와 `Y`에서 공통으로 나타나는 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다(`X`에는 5가 3개, `Y`에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)두 정수 `X`, `Y`가 주어졌을 때, `X`, `Y`의 짝꿍을 return하는 solution 함수를 완성해주세요.

### 제한사항

- 3 ≤ `X`, `Y`의 길이(자릿수) ≤ 3,000,000입니다.
- `X`, `Y`는 0으로 시작하지 않습니다.
- `X`, `Y`의 짝꿍은 상당히 큰 정수일 수 있으므로, 문자열로 반환합니다.

---

### 입출력 예

| X | Y | result |
| --- | --- | --- |
| "100" | "2345" | "-1" |
| "100" | "203045" | "0" |
| "100" | "123450" | "10" |
| "12321" | "42531" | "321" |
| "5525" | "1255" | "552" |

---

### 입출력 예 설명

**입출력 예 #1**

- `X`, `Y`의 짝꿍은 존재하지 않습니다. 따라서 "-1"을 return합니다.

**입출력 예 #2**

- `X`, `Y`의 공통된 숫자는 0으로만 구성되어 있기 때문에, 두 수의 짝꿍은 정수 0입니다. 따라서 "0"을 return합니다.

**입출력 예 #3**

- `X`, `Y`의 짝꿍은 10이므로, "10"을 return합니다.

**입출력 예 #4**

- `X`, `Y`의 짝꿍은 321입니다. 따라서 "321"을 return합니다.

**입출력 예 #5**

- 지문에 설명된 예시와 같습니다.

---

### 풀이

1. 숫자별로 개수를 센다.
2. X, Y가 중복 수의 개수를 구해서 가장 큰 수부터 answer에 더한다.

```java
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder answerStr = new StringBuilder();
        
        HashMap<Character, Integer> xNums = new HashMap<>();
        HashMap<Character, Integer> yNums = new HashMap<>();
        // 숫자별 개수 count
        countNum(xNums, X);
        countNum(yNums, Y);
        
        // 내림차순 정렬
        Object[] xArr = xNums.keySet().toArray();
        Arrays.sort(xArr);
        
        for (int i = xArr.length - 1; i >= 0; i--) {
            int xCnt = xNums.getOrDefault(xArr[i], 0);
            int yCnt = yNums.getOrDefault(xArr[i], 0);
            if (yCnt > 0) {
                int pairCnt = xCnt;
                if (yCnt < xCnt) {
                    pairCnt = yCnt;
                }
                for (int j = 0; j < pairCnt; j++) {
                    answerStr.append((char)xArr[i]);
                }
            }
        }
        
        answer = answerStr.toString();
        // 짝꿍이 존재하지 않거나 0으로만 구성된 경우
        if (answer.length() == 0) {
            answer = "-1";
        } else if (answer.split("0").length == 0) {
            answer = "0";
        }
        
        return answer;
    }
    
    public void countNum(HashMap<Character, Integer> map, String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
    }
}
```

<details><summary>결과</summary>
<p>

    | 테스트 1 〉 | 통과 (0.31ms, 67.8MB) |
    | --- | --- |
    | 테스트 2 〉 | 통과 (0.29ms, 75.5MB) |
    | 테스트 3 〉 | 통과 (0.34ms, 73.1MB) |
    | 테스트 4 〉 | 통과 (0.32ms, 72.4MB) |
    | 테스트 5 〉 | 통과 (0.46ms, 83.5MB) |
    | 테스트 6 〉 | 통과 (1.25ms, 74.1MB) |
    | 테스트 7 〉 | 통과 (1.33ms, 71.6MB) |
    | 테스트 8 〉 | 통과 (1.37ms, 74.4MB) |
    | 테스트 9 〉 | 통과 (1.62ms, 75.5MB) |
    | 테스트 10 〉 | 통과 (1.07ms, 77.8MB) |
    | 테스트 11 〉 | 통과 (205.69ms, 181MB) |
    | 테스트 12 〉 | 통과 (243.96ms, 181MB) |
    | 테스트 13 〉 | 통과 (307.98ms, 167MB) |
    | 테스트 14 〉 | 통과 (230.69ms, 167MB) |
    | 테스트 15 〉 | 통과 (302.82ms, 186MB) |
    | 테스트 16 〉 | 통과 (0.45ms, 77.2MB) |
    | 테스트 17 〉 | 통과 (0.36ms, 73.7MB) |
    | 테스트 18 〉 | 통과 (0.32ms, 75.3MB) |
    | 테스트 19 〉 | 통과 (0.33ms, 78.7MB) |


</details>

- StringBuilder를 쓰지 않으면 시간초과가 난다. 뭔가 찝찝하다.
    
    0부터 9까지의 범위 내에서 구해보라는 이야기가 있어서 해보았다.
    

```java
import java.util.Arrays;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder answerStr = new StringBuilder();
        
        int[] xNums = new int[10];
        int[] yNums = new int[10];
        // 숫자별 개수 count
        countNum(xNums, X);
        countNum(yNums, Y);
        
        for (int num = 9; num >= 0; num--) {
            int pairCnt = xNums[num];
            if (yNums[num] < pairCnt) {
                pairCnt = yNums[num];
            }
            for (int i = 0; i < pairCnt; i++) {
                answerStr.append(Integer.toString(num));
            }
        }
        
        answer = answerStr.toString();
        // 짝꿍이 존재하지 않거나 0으로만 구성된 경우
        if (answer.length() == 0) {
            answer = "-1";
        } else if (answer.split("0").length == 0) {
            answer = "0";
        }
        
        return answer;
    }
    
    public void countNum(int[] nums, String s) {
        for (int i = 0; i <= 9; i++) {
            String num = Integer.toString(i);
            nums[i] = s.length() - s.replace(num, "").length();
        }
    }
}
```

<details><summary>결과</summary>
<p>

    | 테스트 1 〉 | 통과 (0.12ms, 78MB) |
    | --- | --- |
    | 테스트 2 〉 | 통과 (0.13ms, 77.2MB) |
    | 테스트 3 〉 | 통과 (0.15ms, 75.1MB) |
    | 테스트 4 〉 | 통과 (0.12ms, 76.3MB) |
    | 테스트 5 〉 | 통과 (0.14ms, 66.7MB) |
    | 테스트 6 〉 | 통과 (1.50ms, 83.7MB) |
    | 테스트 7 〉 | 통과 (0.82ms, 70.1MB) |
    | 테스트 8 〉 | 통과 (2.33ms, 82.6MB) |
    | 테스트 9 〉 | 통과 (3.38ms, 66.4MB) |
    | 테스트 10 〉 | 통과 (3.23ms, 83.9MB) |
    | 테스트 11 〉 | 통과 (441.81ms, 237MB) |
    | 테스트 12 〉 | 통과 (473.34ms, 239MB) |
    | 테스트 13 〉 | 통과 (478.58ms, 237MB) |
    | 테스트 14 〉 | 통과 (473.64ms, 233MB) |
    | 테스트 15 〉 | 통과 (417.27ms, 258MB) |
    | 테스트 16 〉 | 통과 (0.21ms, 71.2MB) |
    | 테스트 17 〉 | 통과 (0.19ms, 72.7MB) |
    | 테스트 18 〉 | 통과 (0.10ms, 78.8MB) |
    | 테스트 19 〉 | 통과 (0.13ms, 67.4MB) |

</details>

머랄가.. 코드는 이뻐진 것 같기도 한데.. 실행시간만 놓고 보면 이전의 코드가 더 낫다..

암튼 String의 + 연산은 되도록 피하자..

(이 얘기.. cspark 교수님께 들은 것 같기도..)