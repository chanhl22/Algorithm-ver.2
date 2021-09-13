import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

class Solution25 {
    static int cal_time(String start, String end, int[] fees) {
        int ret = 0;
        String[] start_t = start.split(":");
        String[] end_t = end.split(":");
        int hour = Integer.parseInt(end_t[0]) - Integer.parseInt(start_t[0]);
        int min = 0;
        if (Integer.parseInt(end_t[1]) > Integer.parseInt(start_t[1])) {
            min = Integer.parseInt(end_t[1]) - Integer.parseInt(start_t[1]);
        } else if (Integer.parseInt(end_t[1]) < Integer.parseInt(start_t[1])) {
            min = 60 - (Integer.parseInt(start_t[1]) - Integer.parseInt(end_t[1]));
            hour--;
        }
        ret = hour * 60 + min;
        return ret;
    }

    public int[] solution(int[] fees, String[] records) {
        int n = records.length;
        String[] d_time = new String[n];
        String[] car_num = new String[n];
        String[] in_out = new String[n];
        for (int i = 0; i < n; i++) {
            String[] s = records[i].split(" ");
            d_time[i] = s[0];
            car_num[i] = s[1];
            in_out[i] = s[2];
        }
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(car_num[i]);
        }
        ArrayList<String> a = new ArrayList<>(set);
        Collections.sort(a);
        int[] answer = new int[a.size()];
        for (int i = 0; i < a.size(); i++) { //차 하나씩 계산
            boolean ok = false; //입차, 출차
            String s_time = "";
            String e_time = "";
            int time_sum = 0;
            for (int j = 0; j < n; j++) {
                if (a.get(i).equals(car_num[j])) {
                    if (ok == true) {
                        e_time = d_time[j];
                        ok = false;
                        time_sum += cal_time(s_time, e_time, fees);
                        s_time = "";
                        e_time = "";
                    } else {
                        s_time = d_time[j];
                        ok = true; //입차
                    }
                }
            }
            if (ok == true) {
                time_sum += cal_time(s_time, "23:59", fees);
            }
            double fee = 0;
            if (time_sum > fees[0]) {
                fee = fees[1] + Math.ceil((double) (time_sum - fees[0]) / fees[2]) * fees[3];
            } else {
                fee = fees[1];
            }
            answer[i] = (int) fee;
        }
        return answer;
    }
}


public class KK3 {
    public static void main(String[] args) {
        Solution25 sol = new Solution25();
        int[] ans = sol.solution(new int[]{180, 5000, 10, 600}, new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
        //int[] ans = sol.solution(new int[]{120, 0, 60, 591}, new String[]{"16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"});
        //int[] ans = sol.solution(new int[]{1, 461, 1, 10}, new String[]{"00:00 1234 IN"});
        System.out.println(Arrays.toString(ans));
    }
}