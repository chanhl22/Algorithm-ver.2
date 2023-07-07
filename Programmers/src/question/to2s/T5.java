package question.to2s;

import java.util.Arrays;
import java.util.HashSet;

class SolutionT5 {

    private static final HashSet<Integer> answer = new HashSet<>();

    public int[] solution(int[] fruitWeights, int k) {
        go(0, 0, 0, fruitWeights, k);

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private void go(int index, int start, int result, int[] fruitWeights, int k) {
        if (index == k) {
            answer.add(result);
            return;
        }

        for (int i = start; i < fruitWeights.length; i++) {
            go(index + 1, i + 1, Math.max(result, fruitWeights[i]), fruitWeights, k);
        }
    }
}


public class T5 {
    public static void main(String[] args) {
        SolutionT5 sol = new SolutionT5();
        int[] ans = sol.solution(new int[]{30, 40, 10, 20, 30}, 3);
//        int[] ans = sol.solution(new int[]{30, 40, 10}, 2);
        System.out.println(Arrays.toString(ans));
    }
}