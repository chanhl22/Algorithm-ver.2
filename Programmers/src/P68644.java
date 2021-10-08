import java.util.*;

class Solution45 {
    public int[] solution(int[] numbers) {
        HashSet<Integer> set = new HashSet<>();
        int n = numbers.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                set.add(numbers[i] + numbers[j]);
            }
        }
        ArrayList<Integer> a = new ArrayList<>(set);
        Collections.sort(a);
        int[] answer = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            answer[i] = a.get(i);
        }
        return answer;
    }
}

public class P68644 {
    public static void main(String[] args) {
        Solution45 sol = new Solution45();
        int[] ans = sol.solution(new int[]{2, 1, 3, 4, 1});
        System.out.println(ans);
    }
}