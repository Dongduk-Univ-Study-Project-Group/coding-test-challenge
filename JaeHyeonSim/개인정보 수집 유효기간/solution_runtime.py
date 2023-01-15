import datetime as dt
import re

def solution(today, terms, privacies):
    answer = []
    
    t = today.split(".")    # 오늘 날짜 str to date
    tDate = dt.datetime(int(t[0]), int(t[1]), int(t[2]))
    
    termDict = {}           # 약관 종류별 유효기간
    for term in terms:
        termDict[term.split()[0]] = int(term.split()[1])
    
    index = 1
    for privacie in privacies:
        p = re.split("[. ]", privacie)
        
        year = int(p[0])
        month = int(p[1])
        day = int(p[2])
        
        month += termDict.get(p[3])     # 약관에 맞는 기간을 더한다
        if month > 12:                  # 12월을 넘어갔을 때 year, month 처리
            year += month // 12
            month = (month - 12) % 12
        
        pDate = dt.datetime(year, month, day)   # 만료일과 날짜 비교
        if tDate >= pDate:
            answer.append(index)
        index += 1
    
    return answer
