import java.util.Arrays;

class Solution51 {
    public int[] solution(int[] arr) {
        int[] answer = new int[3];
        int one = 0;
        int two = 0;
        int three = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                one++;
            } else if (arr[i] == 2) {
                two++;
            } else {
                three++;
            }
        }
        int max = Math.max(one, Math.max(two, three));
        answer[0] = max - one;
        answer[1] = max - two;
        answer[2] = max - three;
        return answer;
    }
}


public class WO1 {
    public static void main(String[] args) {
        Solution51 sol = new Solution51();
        //int[] ans = sol.solution(new int[]{2, 1, 3, 1, 2, 1});
        int[] ans = sol.solution(new int[]{3, 3, 3, 3, 3, 3});
        System.out.println(Arrays.toString(ans));
    }
}