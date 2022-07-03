package question;

class Solution130 {
    public int solution(int[] grade) {
        int answer = 0;
        boolean firstCheck = checkGrade(grade);
        if (!firstCheck) {
            answer = changeGrade(grade);
        }
        return answer;
    }

    private int changeGrade(int[] grade) {
        int n = grade.length;
        int max = grade[n - 1];
        int ret = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (grade[i] > max) {
                ret += grade[i] - max;
                grade[i] = max;
            } else {
                max = grade[i];
            }
        }
        return ret;
    }

    private boolean checkGrade(int[] grade) {
        int n = grade.length;
        boolean isOk = true;
        for (int i = 0, j = 1; i < n - 1; i++, j++) {
            if (grade[i] > grade[j]) {
                isOk = false;
            }
        }
        return isOk;
    }
}

public class Dev1_2_2022 {
    public static void main(String[] args) {
        Solution130 sol = new Solution130();
        int ans = 0;
//        ans = sol.solution(new int[]{2, 1, 3});
//        ans = sol.solution(new int[]{1, 2, 3});
        ans = sol.solution(new int[]{3, 2, 3, 6, 4, 5});
        System.out.println(ans);
    }
}