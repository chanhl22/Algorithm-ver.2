/**
 * 2025 프로그래머스 코드챌린지 1차 예선 > 유연근무제
 * playtime = 47m 27s
 */

import java.util.ArrayList;
import java.util.stream.IntStream;

public class P388351 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] schedules = {700, 800, 1100};
        int[][] timelogs = {
                {710, 2359, 1050, 700, 650, 631, 659},
                {800, 801, 805, 800, 759, 810, 809},
                {1105, 1001, 1002, 600, 1059, 1001, 1100}
        };
        int startday = 5;

        int ans;
        ans = sol.solution(schedules, timelogs, startday);
        System.out.println(ans);
    }

    static class Solution {
        public int solution(int[] schedules, int[][] timelogs, int startday) {
            int excludeDay = (7 - startday) % 7;
            int exclude1 = excludeDay == 0 ? 7 : excludeDay;
            int exclude2 = excludeDay + 1;
            int excludeIndex1 = exclude1 - 1;
            int excludeIndex2 = exclude2 - 1;

            ArrayList<Integer> schedulesList = convertSchedulesInt(schedules);
            ArrayList<ArrayList<Integer>> timeLogsList = convertTimeLogsInt(timelogs);

            int count = 0;
            for (int i = 0; i < schedulesList.size(); i++) {
                Integer currentSchedule = schedulesList.get(i);
                ArrayList<Integer> currentTimeLogs = timeLogsList.get(i);
                boolean allMatch = IntStream.range(0, currentTimeLogs.size())
                        .filter(index -> index != excludeIndex1)
                        .filter(index -> index != excludeIndex2)
                        .mapToObj(currentTimeLogs::get)
                        .allMatch(currentTimeLog -> currentTimeLog <= currentSchedule + 10);
                if (allMatch) {
                    count++;
                }
            }

            return count;
        }

        private ArrayList<ArrayList<Integer>> convertTimeLogsInt(int[][] timelogs) {
            ArrayList<ArrayList<Integer>> timelogsInt = new ArrayList<>();
            for (int[] timeLog : timelogs) {
                ArrayList<Integer> timelogInt = new ArrayList<>();
                for (int time : timeLog) {
                    timelogInt.add(convertMin(time));
                }
                timelogsInt.add(timelogInt);
            }
            return timelogsInt;
        }

        private ArrayList<Integer> convertSchedulesInt(int[] schedules) {
            ArrayList<Integer> schedulesInt = new ArrayList<>();
            for (int schedule : schedules) {
                schedulesInt.add(convertMin(schedule));
            }
            return schedulesInt;
        }

        private int convertMin(int value) {
            int hour = value / 100;
            int min = value % 100;

            return hour * 60 + min;
        }
    }
}