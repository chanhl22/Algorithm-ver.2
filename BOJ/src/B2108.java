//playtime = 52:12

import java.util.Arrays;
import java.util.Scanner;

public class B2108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }
        double one = 0;
        for (int i = 0; i < n; i++) {
            one += numbers[i];
        }
        System.out.println(Math.round(one / n)); //산술평균
        Arrays.sort(numbers);
        System.out.println(numbers[n / 2]); //중앙값
        boolean flag = false;
        int mode_max = 0;
        int mode = 10000;
        for(int i = 0; i < n; i++) {
            int jump = 0;	// 동일한 수가 나온만큼 i 값 jump 시킬 변수
            int count = 1;
            int i_value = numbers[i];
            for(int j = i + 1; j < n; j++){
                if(i_value != numbers[j]) {
                    break;
                }
                count++;
                jump++;
            }
            if(count > mode_max) {
                mode_max = count;
                mode = i_value;
                flag = true;
            }
            else if(count == mode_max && flag == true) {
                mode = i_value;
                flag = false;
            }
            i += jump;
        }
        System.out.println(mode); //최빈값
        System.out.println(numbers[n-1] - numbers[0]); //범위
    }
}
