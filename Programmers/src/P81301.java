class Solution1 {
    public int solution(String s) {
        s = s.replace("zero","0");
        s = s.replace("one","1");
        s = s.replace("two","2");
        s = s.replace("three","3");
        s = s.replace("four","4");
        s = s.replace("five","5");
        s = s.replace("six","6");
        s = s.replace("seven","7");
        s = s.replace("eight","8");
        s = s.replace("nine","9");

        int answer = Integer.valueOf(s);

        return answer;
    }
}

public class K81301 {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        int ans = sol.solution("one4seveneight");
        System.out.println(ans);
        ans = sol.solution("23four5six7");
        System.out.println(ans);
        ans = sol.solution("2three45sixseven");
        System.out.println(ans);
        ans = sol.solution("123");
        System.out.println(ans);
    }
}
