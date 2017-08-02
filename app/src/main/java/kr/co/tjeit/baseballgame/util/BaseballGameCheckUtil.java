package kr.co.tjeit.baseballgame.util;

import android.util.Log;

/**
 * Created by the on 2017-08-02.
 */

public class BaseballGameCheckUtil {

    public int[] problem = {5, 7, 9};

    public BaseballGameCheckUtil() {
        Log.d("kj", "문제 출제 필요");
        // 문제를 내는 로직 만들면 된다.


        int problemNumber = 0;
        while (true) {

            problemNumber = (int) (Math.random() * 900) + 100;
            // math.random() => 0~1 사이의 소수가 리턴
            // 이를 이용해 100~999 사이의 숫자.
            // 0 ~ 1 => 0 ~ 899 => 100 ~ 999

            Log.d("problem", problemNumber + "");

            problem[2] = problemNumber % 10;
            problemNumber /= 10;

            problem[1] = problemNumber % 10;
            problemNumber /= 10;

            problem[0] = problemNumber % 10;

            if (!(problem[0] == problem[1] || problem[1] == problem[2] || problem[0] == problem[2])) {
                break;
            }

        }


    }

    // 157 % 10 => 157을 10으로 나눈 나머지 => {1,5,7}

    public int[] checkInputToProblem(int inputNumber) {
        int[] inputArray = new int[3];

        inputArray[2] = inputNumber % 10;
        // 157이 들어왔으면 7을 마지막 칸에 저장
        // 다음자리를 떼내려면 157 => 15로 바꾸면 편하겠다.
        // 그러니 inputNumber를 1/10으로 줄여주자.

        inputNumber /= 10;
        // inputNumber를 1/10으로 줄여서 저장하는 연산자.

        inputArray[1] = inputNumber % 10;
        // 15에서 5를 떼다가 가운데 칸에 저장.

        inputNumber /= 10;
        // 15 => 1

        inputArray[0] = inputNumber % 10;

        Log.d("Array", "" + inputArray[0] + inputArray[1] + inputArray[2] + "");

        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (inputArray[i] == problem[j]) {

                    if (i == j) {
                        // 스트라이크 하나 추가
                        strike++;
                    } else {
                        // 볼 하나 추가
                        ball++;
                    }

                }
            }
        }

        Log.d("S,B", strike + "S" + ball + "B");

        int[] returnArray = new int[2];
        returnArray[0] = strike;
        returnArray[1] = ball;

        return returnArray;

    }

}
