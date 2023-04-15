/**
 * playtime : 01:49:47
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Task176962 {
    String name;
    int startTime;
    int endTime;
    int progress;
    int remain;

    public Task176962(String name, int startTime, int progress) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = startTime + progress;
        this.progress = progress;
        this.remain = progress;
    }

    public int getProgress() {
        return progress;
    }

    public int getRemain() {
        return remain;
    }

    public String getName() {
        return name;
    }

    public void minusRemain() {
        this.remain--;
    }
}

class Solution176962 {
    public String[] solution(String[][] plans) {
        List<String> answer = new ArrayList<>();
        List<Task176962> list = new ArrayList<>();
        init(list, plans);

        int startTime = list.get(0).startTime;
        int endTime = list.get(list.size() - 1).endTime;

        int cur = 0;
        int next = 1;

        for (int i = startTime; i <= endTime; i++) {
            if (cur < list.size() - 1 && i == list.get(next).startTime) {
                cur++;
                next++;
            }

            if (list.get(cur).startTime <= i && i < list.get(cur).endTime) {
                list.get(cur).minusRemain();
                if (list.get(cur).getRemain() == 0) {
                    answer.add(list.get(cur).getName());
                }
            } else {
                for (int j = cur; j >= 0; j--) {
                    if (list.get(j).getRemain() > 0) {
                        list.get(j).minusRemain();
                        if (list.get(j).getRemain() == 0) {
                            answer.add(list.get(j).getName());
                        }
                        break;
                    }
                }
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).getRemain() > 0) {
                answer.add(list.get(i).getName());
            }
        }

        return answer.toArray(new String[plans.length]);
    }

    private void init(List<Task176962> list, String[][] plans) {
        for (String[] plan : plans) {
            list.add(new Task176962(plan[0], covertTime(plan[1]), Integer.parseInt(plan[2])));
        }
        list.sort(Comparator.comparingInt(o -> o.startTime));
    }

    private int covertTime(String time) {
        String[] str = time.split(":");
        return Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
    }
}

public class P176962 {
    public static void main(String[] args) {
        Solution176962 sol = new Solution176962();
//        String[] ans = sol.solution(
//                new String[][]{{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}});
        String[] ans = sol.solution(
                new String[][]{{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}});
        System.out.println(Arrays.toString(ans));
    }
}

