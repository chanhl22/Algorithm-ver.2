import java.util.Arrays;

class Solution76 {
    static int[][] map = new int[5][6000];

    public int solution(String[][] schedule) {
        int answer = 0;
        int ret = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        for (int m = 0; m < 4; m++) {
                            form(schedule[0][i], schedule[1][j], schedule[2][k], schedule[3][l], schedule[4][m]);
                            boolean ok = check_map();
                            if (ok) {
                                ret++;
                            }
                            for (int n = 0; n < 5; n++) {
                                Arrays.fill(map[n], 0);
                            }
                        }
                    }
                }
            }
        }
        if (ret != 0) {
            answer = ret;
        }
        return answer;
    }

    private boolean check_map() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 6000; j++) {
                if (map[i][j] == 2) {
                    return false;
                }
            }
        }
        return true;
    }

    private void form(String s1, String s2, String s3, String s4, String s5) {
        length_check(s1);
        length_check(s2);
        length_check(s3);
        length_check(s4);
        length_check(s5);
    }

    private void length_check(String s) {
        if (s.length() > 10) {
            separation1(s);
        } else {
            separation2(s);
        }
    }

    private void separation1(String s) {
        String[] temp = s.split(" ");
        String[] time1_tmp = temp[1].split(":");
        String[] time2_tmp = temp[3].split(":");
        int first_time = Integer.parseInt(time1_tmp[0]) * 60 + Integer.parseInt(time1_tmp[1]);
        int second_time = Integer.parseInt(time2_tmp[0]) * 60 + Integer.parseInt(time2_tmp[1]);
        int first_day = check_day(temp[0]);
        int second_day = check_day(temp[2]);
        for (int i = first_time; i < first_time + 90; i++) {
            if (map[first_day][i] == 0) {
                map[first_day][i] = 1;
            } else if (map[first_day][i] == 1) {
                map[first_day][i] = 2;
            }
        }
        for (int i = second_time; i < second_time + 90; i++) {
            if (map[second_day][i] == 0) {
                map[second_day][i] = 1;
            } else if (map[second_day][i] == 1) {
                map[second_day][i] = 2;
            }
        }
    }

    private void separation2(String s) {
        String[] temp = s.split(" ");
        String[] time_tmp = temp[1].split(":");
        int time = Integer.parseInt(time_tmp[0]) * 60 + Integer.parseInt(time_tmp[1]);
        int day = check_day(temp[0]);
        for (int i = time; i < time + 180; i++) {
            if (map[day][i] == 0) {
                map[day][i] = 1;
            } else if (map[day][i] == 1) {
                map[day][i] = 2;
            }
        }
    }

    private int check_day(String s) {
        if (s.equals("MO")) {
            return 0;
        } else if (s.equals("TU")) {
            return 1;
        } else if (s.equals("WE")) {
            return 2;
        } else if (s.equals("TH")) {
            return 3;
        } else {
            return 4;
        }
    }
}


public class KKOB3 {
    public static void main(String[] args) {
        Solution76 sol = new Solution76();
        int ans = 0;
        ans = sol.solution(new String[][]{{"MO 12:00 WE 14:30", "MO 12:00", "MO 15:00", "MO 18:00"},
                {"TU 09:00", "TU 10:00", "TU 15:00", "TU 18:00"},
                {"WE 09:00", "WE 12:00", "WE 15:00", "WE 18:00"},
                {"TH 09:30", "TH 11:30", "TH 15:00", "TH 18:00"},
                {"FR 15:00", "FR 15:00", "FR 15:00", "FR 15:00"}}
        );
        System.out.println(ans);
    }
}