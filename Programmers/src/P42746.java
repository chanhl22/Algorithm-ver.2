import java.util.*;

class Solution36 {
    public String solution(int[] numbers) {
        String answer = "";
        int n = numbers.length;
        String[] number = new String[n];
        for (int i = 0; i < n; i++) {
            number[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(number, (x, y) -> (y + x).compareTo(x + y));
        for (int i = 0; i < n; i++) {
            answer += number[i];
        }
        if (answer.charAt(0) == '0') {
            return "0";
        }
        return answer;
    }
}

public class P42746 {
    public static void main(String[] args) {
        Solution36 sol = new Solution36();
        //String ans = sol.solution(new int[]{6, 10, 2});
        String ans = sol.solution(new int[]{3, 30, 34, 5, 9});
        System.out.println(ans);
    }
}