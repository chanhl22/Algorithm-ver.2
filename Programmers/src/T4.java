class Solution13 {
    public String solution(String input) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        sb.append(input.charAt(0));
        sb.append(input.charAt(1));
        sb.append(input.charAt(2));
        int i = 0;
        int m = input.charAt(0) - '0';
        int n = input.charAt(2) - '0';
        int date = 0;
        while(i < input.length()) {
            if (input.charAt(i) == 'S') {
                i += 3;
                if (m < 0) {
                    sb.append(0);
                } else {
                    sb.append(1);
                }
            } else if (input.charAt(i) == 'N') {
                if (input.charAt(i+2) == 'G') {
                    i += 7;
                    sb.append(0);
                } else if (input.charAt(i+2) == 'X') {
                    date += 1;
                    i += 3;
                    sb.append('-');
                }
            } else if (input.charAt(i) == 'E') {
                i += 3;
                sb.append("BYE");
                break;
            }
        }
        answer = sb.toString();
        return answer;
    }
}


public class T4 {
    public static void main(String[] args) {
        Solution13 sol = new Solution13();
        String ans = "";
        ans = sol.solution("1 2SHOWSHOWNEXTSHOWNEXTSHOWNEXTSHOWEXIT");
        System.out.println(ans);
    }
}