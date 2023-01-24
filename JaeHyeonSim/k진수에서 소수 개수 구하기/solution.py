def solution(n, k):
    answer = 0
    
    kNum = getKNum(n, k)        # k진수 변환
    splited = kNum.split("0")   # 0을 기준으로 나누기
    for num in splited:
        if num != "" and isPrime(int(num)): # 소수 판별
            answer += 1
            
    return answer

def getKNum(n, k):
    kNum = []
    while n / k > 0:
        kNum.append(str(n % k))
        n //= k
    kNum.reverse()
    return "".join(kNum)

def isPrime(n):
    if n == 1:
        return False
    for i in range(2, int(n ** 0.5) + 1):
        if n % i == 0:
            return False
    return True
