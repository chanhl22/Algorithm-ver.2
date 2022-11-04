// playtime = 3:51

class Solution134240 {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                sb.append(i);
            }
        }
        return sb.toString() + 0 + sb.reverse();
    }
}

public class P134240 {
    public static void main(String[] args) {
        Solution134240 sol = new Solution134240();
        String ans = sol.solution(new int[]{1, 3, 4, 6});
        System.out.println(ans);
    }
}