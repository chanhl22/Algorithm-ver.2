import java.util.*;

class Solution40 {
    public int[] solution(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (a.size() == 0) {
                a.add(arr[i]);
            } else if (a.get(a.size() - 1) != arr[i]) {
                a.add(arr[i]);
            }
        }
        int[] answer = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            answer[i] = a.get(i);
        }
        return answer;
    }
}


public class P12906 {
    public static void main(String[] args) {
        Solution40 sol = new Solution40();
        int[] ans = sol.solution(new int[]{1, 1, 3, 3, 0, 1, 1});
        System.out.println(Arrays.toString(ans));
    }
}