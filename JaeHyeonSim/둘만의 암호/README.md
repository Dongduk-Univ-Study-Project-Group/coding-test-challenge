
### **문제 설명**

두 문자열 `s`와 `skip`, 그리고 자연수 `index`가 주어질 때, 다음 규칙에 따라 문자열을 만들려 합니다. 암호의 규칙은 다음과 같습니다.

- 문자열 `s`의 각 알파벳을 `index`만큼 뒤의 알파벳으로 바꿔줍니다.
- `index`만큼의 뒤의 알파벳이 `z`를 넘어갈 경우 다시 `a`로 돌아갑니다.
- `skip`에 있는 알파벳은 제외하고 건너뜁니다.

예를 들어 `s` = "aukks", `skip` = "wbqd", `index` = 5일 때, a에서 5만큼 뒤에 있는 알파벳은 f지만 [b, c, d, e, f]에서 'b'와 'd'는 `skip`에 포함되므로 세지 않습니다. 따라서 'b', 'd'를 제외하고 'a'에서 5만큼 뒤에 있는 알파벳은 [c, e, f, g, h] 순서에 의해 'h'가 됩니다. 나머지 "ukks" 또한 위 규칙대로 바꾸면 "appy"가 되며 결과는 "happy"가 됩니다.

두 문자열 `s`와 `skip`, 그리고 자연수 `index`가 매개변수로 주어질 때 위 규칙대로 `s`를 변환한 결과를 return하도록 solution 함수를 완성해주세요.

---

### 제한사항

- 5 ≤ `s`의 길이 ≤ 50
- 1 ≤ `skip`의 길이 ≤ 10
- `s`와 `skip`은 알파벳 소문자로만 이루어져 있습니다.
    - `skip`에 포함되는 알파벳은 `s`에 포함되지 않습니다.
- 1 ≤ `index` ≤ 20

---

### 입출력 예

| s | skip | index | result |
| --- | --- | --- | --- |
| "aukks" | "wbqd" | 5 | "happy" |

---

### 입출력 예 설명

입출력 예 #1본문 내용과 일치합니다.

---

### 풀이

1. skip에 있는 문자를 제외한 알파벳 문자열을 만든다.
2. index를 더한 위치를 찾는다.
    
    ```java
    class Solution {
        public String solution(String s, String skip, int index) {
            String answer = "";
            
            // 알파벳에서 skip에 있는 문자를 제외
            String skipped = "";
            for (char alpha = 'a'; alpha <= 'z'; alpha++) {
                if (skip.indexOf(alpha) == -1) {
                    skipped += alpha;
                }
            }
            
            // skipped 문자열이 알파벳이라고 생각하고 (+ index) 의 위치를 찾음
            for (int i = 0; i < s.length(); i++) {
                int idx = skipped.indexOf(s.charAt(i)) + index;
                // z를 넘어가면 a로
                if (idx >= skipped.length()) {
                    idx -= skipped.length();
                }
                answer += skipped.charAt(idx);
            }
            
            return answer;
        }
    }
    ```

<details><summary>결과</summary>
<p>

        | 테스트 1 〉 | 통과 (13.42ms, 77.4MB) |
        | --- | --- |
        | 테스트 2 〉 | 통과 (13.04ms, 74.8MB) |
        | 테스트 3 〉 | 실패 (런타임 에러) |
        | 테스트 4 〉 | 통과 (12.77ms, 78.9MB) |
        | 테스트 5 〉 | 통과 (15.78ms, 77.2MB) |
        | 테스트 6 〉 | 통과 (13.23ms, 74.9MB) |
        | 테스트 7 〉 | 통과 (9.54ms, 74.9MB) |
        | 테스트 8 〉 | 통과 (17.72ms, 83.1MB) |
        | 테스트 9 〉 | 통과 (15.59ms, 74.1MB) |
        | 테스트 10 〉 | 통과 (11.03ms, 79.5MB) |
        | 테스트 11 〉 | 통과 (9.59ms, 77.6MB) |
        | 테스트 12 〉 | 통과 (11.82ms, 80.3MB) |
        | 테스트 13 〉 | 통과 (11.24ms, 88.9MB) |
        | 테스트 14 〉 | 통과 (11.35ms, 79.3MB) |
        | 테스트 15 〉 | 통과 (13.98ms, 74.1MB) |
        | 테스트 16 〉 | 통과 (13.37ms, 78.8MB) |
        | 테스트 17 〉 | 실패 (런타임 에러) |
        | 테스트 18 〉 | 실패 (런타임 에러) |
        | 테스트 19 〉 | 실패 (런타임 에러) |

</details>

- 해봤자 (알파벳 전체 길이 + s의 길이)만큼 반복문이 돌아갈 거라고 생각했는데 런타임 에러.. 시간을 줄이기 위해 알파벳 연산을 줄였다.

```java
class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            for (int cnt = 0; cnt < index; cnt++) {
                ch++;
                if (ch > 'z') {     // z를 넘어가면 a로
                    ch -= 'z' - 'a' + 1;
                }
                if (skip.indexOf(ch) != -1) {
                    cnt--;  // skip에 포함되면 index로 치지 않음
                }
            }
            
            answer += ch;
        }
        
        return answer;
    }
}
```

<details><summary>결과</summary>
<p>

    | 테스트 1 〉 | 통과 (14.65ms, 81.8MB) |
    | --- | --- |
    | 테스트 2 〉 | 통과 (12.74ms, 79MB) |
    | 테스트 3 〉 | 통과 (13.35ms, 90MB) |
    | 테스트 4 〉 | 통과 (10.02ms, 73.5MB) |
    | 테스트 5 〉 | 통과 (10.86ms, 81.9MB) |
    | 테스트 6 〉 | 통과 (8.92ms, 77.9MB) |
    | 테스트 7 〉 | 통과 (12.91ms, 82.4MB) |
    | 테스트 8 〉 | 통과 (8.67ms, 87.9MB) |
    | 테스트 9 〉 | 통과 (12.41ms, 84.6MB) |
    | 테스트 10 〉 | 통과 (10.43ms, 73.3MB) |
    | 테스트 11 〉 | 통과 (14.32ms, 82.1MB) |
    | 테스트 12 〉 | 통과 (12.52ms, 83.6MB) |
    | 테스트 13 〉 | 통과 (10.96ms, 75.6MB) |
    | 테스트 14 〉 | 통과 (12.34ms, 79.6MB) |
    | 테스트 15 〉 | 통과 (8.75ms, 80MB) |
    | 테스트 16 〉 | 통과 (8.68ms, 78.5MB) |
    | 테스트 17 〉 | 통과 (10.19ms, 77.1MB) |
    | 테스트 18 〉 | 통과 (11.15ms, 77.1MB) |
    | 테스트 19 〉 | 통과 (12.34ms, 74.8MB) |

</details>

런타임에 큰 영향을 준 것 같지 않지만… 통과된 걸 보면 뭔가 오류가 잡힌 듯하다..