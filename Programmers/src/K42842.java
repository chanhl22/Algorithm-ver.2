import java.util.Arrays;

class Solution18 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i = 1; i <= yellow; i++) {
            if (yellow % i == 0) {
                int row = i;
                int col = yellow / i;
                if (row >= col && brown == row + row + 2 + 2 + col + col) {
                    answer[0] = row + 2;
                    answer[1] = col + 2;
                }
            }
        }
        return answer;
    }
}


public class K42842 {
    public static void main(String[] args) {
        Solution18 sol = new Solution18();
        //int[] ans = sol.solution(10, 2);
        //int[] ans = sol.solution(8, 1);
        int[] ans = sol.solution(24, 24);
        System.out.println(Arrays.toString(ans));
    }
}