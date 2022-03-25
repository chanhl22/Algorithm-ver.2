package question;

import java.util.ArrayList;

class Time {
    int start_h;
    int start_m;
    int end_h;
    int end_m;
    String day;

    public Time(int start_h, int start_m, int end_h, int end_m, String day) {
        this.start_h = start_h;
        this.start_m = start_m;
        this.end_h = end_h;
        this.end_m = end_m;
        this.day = day;
    }
}

class Solution72 {
    public int solution(String[][] schedule) {
        int answer = -1;
        int result = 0;
        String[] str = new String[5];
        int n = schedule[0].length;
        for (int i = 0; i < n; i++) {
            str[0] = schedule[0][i];
            for (int j = 0; j < n; j++) {
                str[1] = schedule[1][j];
                for (int k = 0; k < n; k++) {
                    str[2] = schedule[2][k];
                    for (int l = 0; l < n; l++) {
                        str[3] = schedule[3][l];
                        for (int m = 0; m < n; m++) {
                            str[4] = schedule[4][m];
                            if (check(str)) {
                                result++;
                            }
                        }
                    }
                }
            }
        }
        return answer;
    }

    private boolean check(String[] str) {
        ArrayList<Time> t = new ArrayList<>();
        String[] s0 = str[0].split(" ");
        addTime(t, s0);
        String[] s1 = str[1].split(" ");
        addTime(t, s1);
        String[] s2 = str[2].split(" ");
        addTime(t, s2);
        String[] s3 = str[3].split(" ");
        addTime(t, s3);
        String[] s4 = str[4].split(" ");
        addTime(t, s4);
        for (int i = 0; i < t.size(); i++) {
            for (int j = i+1; j < t.size(); j++) {
                if (t.get(i).day.equals(t.get(j).day)) {
                    if (t.get(i).start_h <= t.get(j).start_h && t.get(i).end_h > t.get(j).end_h
                            && t.get(i).start_m <= t.get(j).start_m && t.get(i).end_m > t.get(j).end_m) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private void addTime(ArrayList<Time> t, String[] s0) {
        if (s0.length == 4) {
            String[] temp1 = s0[1].split(":");
            String[] temp2 = s0[3].split(":");
            int start_h = Integer.parseInt(temp1[0]);
            int start_m = Integer.parseInt(temp1[1]);
            int end_h = Integer.parseInt(temp1[0]) + 1;
            int end_m = Integer.parseInt(temp1[1]) + 30;
            if (end_m == 60) {
                end_h++;
                end_m = 0;
            }
            t.add(new Time(start_h, start_m, end_h, end_m, s0[0]));
            start_h = Integer.parseInt(temp2[0]);
            start_m = Integer.parseInt(temp2[1]);
            end_h = Integer.parseInt(temp2[0]) + 1;
            end_m = Integer.parseInt(temp2[1]) + 30;
            if (end_m == 60) {
                end_h++;
                end_m = 0;
            }
            t.add(new Time(start_h, start_m, end_h, end_m, s0[0]));
        } else {
            String[] temp1 = s0[1].split(":");
            int start_h = Integer.parseInt(temp1[0]);
            int start_m = Integer.parseInt(temp1[1]);
            int end_h = Integer.parseInt(temp1[0]) + 3;
            int end_m = Integer.parseInt(temp1[1]);
            t.add(new Time(start_h, start_m, end_h, end_m, s0[0]));
        }
    }
}


public class Ebay1 {
    public static void main(String[] args) {
        Solution72 sol = new Solution72();
        int ans = 0;
        ans = sol.solution(new String[][]{{"MO 12:00 WE 14:30", "MO 12:00", "MO 15:00", "MO 18:00"},
                {"TU 09:00", "TU 10:00", "TU 15:00", "TU 18:00"},
                {"WE 09:00", "WE 12:00", "WE 15:00", "WE 18:00"},
                {"TH 09:30", "TH 11:30", "TH 15:00", "TH 18:00"},
                {"FR 15:00", "FR 15:00", "FR 15:00", "FR 15:00"}});
        System.out.println(ans);
    }
}