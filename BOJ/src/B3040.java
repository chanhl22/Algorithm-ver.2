//2309번과 동일한 문제이다. check배열을 만들지 않고 메모리를 더 줄이는 방법이 존재한다. 2309번 소스코드 참고

import java.util.Scanner;

public class B3040 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[9];
        boolean[] check = new boolean[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            input[i] = sc.nextInt();
            sum += input[i];
        }
        for (int i = 0; i < 9; i++) {
            for (int j = i+1; j < 9; j++) {
                if (sum - input[i] - input[j] == 100) {
                    check[i] = check[j] = true;
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (check[i] == false) {
                System.out.println(input[i]);
            }
        }
    }
}

