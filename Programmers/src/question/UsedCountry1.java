package question;

class Solution112 {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (s.charAt(i) == '1') {
                i = checkOne(s, sb, n, i, count);
            } else if (s.charAt(i) == '2'){
                i = checkTwo(s, sb, n, i, count);
            } else if (s.charAt(i) == '3'){
                i = checkThree(s, sb, n, i, count);
            } else if (s.charAt(i) == '4'){
                i = checkFour(s, sb, n, i, count);
            } else if (s.charAt(i) == '5'){
                i = checkFive(s, sb, n, i, count);
            } else if (s.charAt(i) == '6'){
                i = checkSix(s, sb, n, i, count);
            } else if (s.charAt(i) == '7'){
                i = checkSeven(s, sb, n, i, count);
            } else if (s.charAt(i) == '8'){
                i = checkEight(s, sb, n, i, count);
            } else if (s.charAt(i) == '9'){
                i = checkNine(s, sb, n, i, count);
            }
        }
        String answer = sb.toString();
        return answer;
    }


    private int checkOne(String s, StringBuilder sb, int n, int i, int count) {
        while (i < n && s.charAt(i) == '1') {
            count++;
            i++;
        }
        if (count == 1) {
            sb.append('.');
        } else if (count == 2) {
            sb.append('Q');
        } else if (count == 3) {
            sb.append('Z');
        }
        return i - 1;
    }

    private int checkTwo(String s, StringBuilder sb, int n, int i, int count) {
        while (i < n && s.charAt(i) == '2') {
            count++;
            i++;
        }
        if (count == 1) {
            sb.append('A');
        } else if (count == 2) {
            sb.append('B');
        } else if (count == 3) {
            sb.append('C');
        }
        return i - 1;
    }

    private int checkThree(String s, StringBuilder sb, int n, int i, int count) {
        while (i < n && s.charAt(i) == '3') {
            count++;
            i++;
        }
        if (count == 1) {
            sb.append('D');
        } else if (count == 2) {
            sb.append('E');
        } else if (count == 3) {
            sb.append('F');
        }
        return i - 1;
    }

    private int checkFour(String s, StringBuilder sb, int n, int i, int count) {
        while (i < n && s.charAt(i) == '4') {
            count++;
            i++;
        }
        if (count == 1) {
            sb.append('G');
        } else if (count == 2) {
            sb.append('H');
        } else if (count == 3) {
            sb.append('I');
        }
        return i - 1;
    }

    private int checkFive(String s, StringBuilder sb, int n, int i, int count) {
        while (i < n && s.charAt(i) == '5') {
            count++;
            i++;
        }
        if (count == 1) {
            sb.append('J');
        } else if (count == 2) {
            sb.append('K');
        } else if (count == 3) {
            sb.append('L');
        }
        return i - 1;
    }

    private int checkSix(String s, StringBuilder sb, int n, int i, int count) {
        while (i < n && s.charAt(i) == '6') {
            count++;
            i++;
        }
        if (count == 1) {
            sb.append('M');
        } else if (count == 2) {
            sb.append('N');
        } else if (count == 3) {
            sb.append('O');
        }
        return i - 1;
    }

    private int checkSeven(String s, StringBuilder sb, int n, int i, int count) {
        while (i < n && s.charAt(i) == '7') {
            count++;
            i++;
        }
        if (count == 1) {
            sb.append('P');
        } else if (count == 2) {
            sb.append('R');
        } else if (count == 3) {
            sb.append('S');
        }
        return i - 1;
    }

    private int checkEight(String s, StringBuilder sb, int n, int i, int count) {
        while (i < n && s.charAt(i) == '8') {
            count++;
            i++;
        }
        if (count == 1) {
            sb.append('T');
        } else if (count == 2) {
            sb.append('U');
        } else if (count == 3) {
            sb.append('V');
        }
        return i - 1;
    }

    private int checkNine(String s, StringBuilder sb, int n, int i, int count) {
        while (i < n && s.charAt(i) == '9') {
            count++;
            i++;
        }
        if (count == 1) {
            sb.append('W');
        } else if (count == 2) {
            sb.append('X');
        } else if (count == 3) {
            sb.append('Y');
        }
        return i - 1;
    }
}


public class UsedCountry1 {
    public static void main(String[] args) {
        Solution112 sol = new Solution112();
//        String ans = sol.solution("44335550555666");
//        String ans = sol.solution("9666775553");
        String ans = sol.solution("2220281");
//        String ans = sol.solution("1122");
//        String ans = sol.solution("1101122");
        System.out.println(ans);
    }
}