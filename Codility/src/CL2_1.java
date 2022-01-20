import java.util.ArrayList;
import java.util.Arrays;

class Solution1 {
    public int[] solution(int[] A, int K) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            list.add(A[i]);
        }
        if (A.length == 0) {
            return A;
        }
        for (int i = 0; i < K; i++) {
            int temp = list.remove(list.size() - 1);
            list.add(0, temp);
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}

public class CL2_1 {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
//        int[] ans = sol.solution(new int[]{3, 8, 9, 7, 6}, 3);
        int[] ans = sol.solution(new int[]{}, 1);
        System.out.println(Arrays.toString(ans));
    }
}
