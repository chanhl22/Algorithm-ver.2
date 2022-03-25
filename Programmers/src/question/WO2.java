package question;

class Solution52 {
    public String solution(String[] log) {
        String answer = "";
        int ans_h = 0;
        int ans_m = 0;
        for (int i = 0; i < log.length; i += 2) {
            String[] s = log[i].split(":");
            String[] f = log[i + 1].split(":");
            int s_h = Integer.parseInt(s[0]); //시작 시간
            int s_m = Integer.parseInt(s[1]); //시작 분
            int f_h = Integer.parseInt(f[0]); //종료 시간
            int f_m = Integer.parseInt(f[1]); //종료 분
            if (f_h > s_h) {
                f_h -= 1;
                f_m += 60;
            }
            int ret_h = f_h - s_h;
            int ret_m = f_m - s_m;
            if (ret_h > 2 || (ret_h == 1 && ret_m > 45)) {
                ans_h += 1;
                ans_m += 45;
            } else if (ret_h <= 0 && ret_m < 5) {
                continue;
            } else {
                ans_h += ret_h;
                ans_m += ret_m;
            }
        }
        int a = ans_m / 60;
        int b = ans_m % 60;
        ans_h += a;
        ans_m = b;
        if (ans_h < 10 && ans_m < 10) {
            answer = answer + "0" + ans_h + ":" + "0" + ans_m;
        } else if (ans_m < 10) {
            answer = answer + "0" + ans_h + ":" + "0" + ans_m;
        } else if (ans_h < 10) {
            answer = answer + "0" + ans_h + ":" + ans_m;
        } else {
            answer = answer + ans_h + ":" + ans_m;
        }
        return answer;
    }
}


public class WO2 {
    public static void main(String[] args) {
        Solution52 sol = new Solution52();
        //String ans = sol.solution(new String[]{"08:30", "09:00", "14:00", "16:00", "16:01", "16:06", "16:07", "16:11"});
        String ans = sol.solution(new String[]{"01:00", "08:00", "15:00", "15:04", "23:00", "23:59"});
        System.out.println(ans);
    }
}