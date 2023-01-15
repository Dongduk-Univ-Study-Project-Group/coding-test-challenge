def solution(survey, choices):
    answer = "RCJA"
    
    types = [['R', 'T'], ['C', 'F'], ['J', 'M'], ['A', 'N']]
    point = [0, 3, 2, 1, 0, 1, 2, 3]
    
    sumPoint = {}      # 유형별 점수 저장
    for t in types:
        sumPoint[t[0]] = 0
        sumPoint[t[1]] = 0
    
    for sv, ch in zip(survey, choices):     # 선택지에 따른 점수 
        if ch < 4:
            sumPoint[sv[:1]] += point[ch]
        elif ch > 4:
            sumPoint[sv[1:]] += point[ch]
    
    for t in types:     # 결과
        if sumPoint[t[0]] < sumPoint[t[1]]:
            answer = answer.replace(t[0], t[1])
    
    return answer
