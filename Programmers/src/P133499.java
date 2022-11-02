//playtime = 36:00

class Solution133499 {
    public int solution(String[] babbling) {
        int answer = 0;

        for (String s : babbling) {
            s = s.replaceAll("aya", "1")
                    .replaceAll("ye", "2")
                    .replaceAll("woo", "3")
                    .replaceAll("ma", "4");
            if (s.contains("11") || s.contains("22") || s.contains("33") || s.contains("44")) {
                continue;
            }
            String s1 = s.replaceAll("[1234]", "");
            if ("".equals(s1)) {
                answer++;
            }
        }
        return answer;
    }
}


public class P133499 {
    public static void main(String[] args) {
        Solution133499 sol = new Solution133499();
        int ans = 0;
//        ans = sol.solution(new String[]{"aya", "yee", "u", "maa"});
        ans = sol.solution(new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"});
        System.out.println(ans);
    }
}