import java.util.*;

class Solution42 {
    static int cal(int n) {
        switch (n) {
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int match = 0; //같은 번호 개수
        int zero = 0; //0 개수
        for (int i = 0; i < 6; i++) {
            if (lottos[i] == 0) {
                zero++;
            } else {
                for (int j = 0; j < 6; j++) {
                    if (lottos[i] == win_nums[j]) {
                        match++;
                    }
                }
            }
        }
        int min = match;
        int max = match + zero;
//        answer[0] = Math.min(7 - max, 6);
//        answer[1] = Math.min(7 - min, 6);
        answer[0] = cal(max);
        answer[1] = cal(min);
        return answer;
    }
}

public class P77484 {
    public static void main(String[] args) {
        Solution42 sol = new Solution42();
        int[] ans = sol.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19});
        System.out.println(Arrays.toString(ans));
    }
}