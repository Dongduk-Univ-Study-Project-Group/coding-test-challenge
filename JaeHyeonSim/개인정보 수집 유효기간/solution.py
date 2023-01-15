import re

def solution(today, terms, privacies):
    answer = []
    
    t = today.split(".")    # 오늘 날짜
    tDay = int(t[0]) * 12 * 28 + int(t[1]) * 28 + int(t[2])
    
    termDict = {}           # 약관 종류별 유효기간
    for term in terms:
        termDict[term.split()[0]] = int(term.split()[1])
    
    index = 1
    for privacie in privacies:
        p = re.split("[. ]", privacie)  # '.'과 ' '로 구분
        
        pDay = int(p[0]) * 12 * 28 + int(p[1]) * 28 + int(p[2])
        pDay += termDict.get(p[3]) * 28
        
        if tDay >= pDay:    # 만료일과 날짜 비교
            answer.append(index)
        index += 1
    
    return answer
