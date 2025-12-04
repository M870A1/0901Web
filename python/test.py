# 6 : 가위바위보 게임에서 승리 횟수가 5회 이상일때 게임이 끝나도록 만들어 보자
# 출력결과 : '승리 : 0/5', 패배 : 1, 비김 : 0'
#'승리 : 1/5', 패배 : 1, 비김 : 0'
#'승리 : 2/5', 패배 : 1, 비김 : 0'
#'승리 : 3/5', 패배 : 1, 비김 : 0'
#'승리 : 3/5', 패배 : 2, 비김 : 0'
#'승리 : 4/5', 패배 : 2, 비김 : 0'
#'승리 : 5/5', 패배 : 2, 비김 : 0'
#'다섯번 이겼습니다. 축하합니다.'
import random
data = ['가위', '바위', '보']

win = 0
lose = 0
draw = 0

while win < 5:
    # input(설명문) : 데이터를 입력하는 함수
    inputData = input("가위, 바위, 보 중에 입력해주세요 >> ")
	# random.choice(리스트) : 리스트중에 하나를 랜덤으로 출력하는 함수
    randomValue = random.choice(data)
    print(f"컴퓨터 : {randomValue}")
    print(f"플레이어 : {inputData}")

    if inputData == randomValue:
        draw += 1
        print("비겼습니다.")
    elif (inputData == '가위' and randomValue == '보' or 
         inputData == '바위' and randomValue == '가위' or
         inputData == '보' and randomValue == '바위'):
        win += 1
        print("승리했습니다!")
    else:
        lose += 1
        print("졌습니다.")
    
        

    print(f"승리 : {win}/5, 패배 : {lose}, 비김 : {draw}")
    print("")
print("다섯 번 이겼습니다. 축하합니다!")