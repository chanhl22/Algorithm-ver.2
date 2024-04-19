/**
 * 비트연산자 문제
 *
 * 비트연산 x 풀이 : https://codemasterkimc.tistory.com/185
 */

import java.util.Scanner;

public class B1740 {
    public static void main(String[] args) {
        long inputNum = input();

        long outputNum = 0L;
        while (inputNum > 0L) {
            long tempCnt = 0L;
            long num = 1L;
            while (inputNum >= num * 2L) {
                num *= 2L;
                tempCnt++;
            }
            inputNum -= num;
            outputNum += myPowBy3(tempCnt);
        }
        System.out.println(outputNum);
    }

    private static long input() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLong();
    }

    private static long myPowBy3(Long tempCnt) {
        long retVal = 1L;
        for (int i = 0; i < tempCnt; i++) {
            retVal *= 3;
        }
        return retVal;
    }
}
