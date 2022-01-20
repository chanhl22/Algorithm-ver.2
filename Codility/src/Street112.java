import java.util.ArrayList;

class Solution63 {
    public int solution(String S) {
        // write your code in Java SE 11
        int temp = 1;
        int max = 0;
        int n = S.length();
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (S.charAt(i - 1) == S.charAt(i)) {
                temp++;
            } else {
                a.add(temp);
                temp = 1;
            }
            if (i == n - 1) {
                a.add(temp);
            }
            if (temp > max) {
                max = temp;
            }
        }
        int answer = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) < max) {
                answer += max - a.get(i);
            }
        }
        return answer;
    }
}


public class Street112 {
    public static void main(String[] args) {
        Solution63 sol = new Solution63();
        int ans = 0;
        //ans = sol.solution("babaa");
        //ans = sol.solution("bbbab");
        //ans = sol.solution("bbbabbb");
        //ans = sol.solution("bbba");
        //ans = sol.solution("bbbaaabbb");
        ans = sol.solution("bbbbb");
        System.out.println(ans);
    }
}