/**
 * 과제는 시작하기로 한 시각이 되면 시작합니다.
 * 새로운 과제를 시작할 시각이 되었을 때, 기존에 진행 중이던 과제가 있다면 진행 중이던 과제를 멈추고 새로운 과제를 시작합니다.
 * 진행중이던 과제를 끝냈을 때, 잠시 멈춘 과제가 있다면, 멈춰둔 과제를 이어서 진행합니다.
 * 만약, 과제를 끝낸 시각에 새로 시작해야 되는 과제와 잠시 멈춰둔 과제가 모두 있다면, 새로 시작해야 하는 과제부터 진행합니다.
 * 멈춰둔 과제가 여러 개일 경우, 가장 최근에 멈춘 과제부터 시작합니다.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Task176962 {
    String name;
    int startTime;
    int progress;
    int remain;

    public Task176962(String name, int startTime, int progress) {
        this.name = name;
        this.startTime = startTime;
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

    public void setRemain(int remain) {
        this.remain = remain;
    }
}

class Solution176962 {
    public String[] solution(String[][] plans) {
        List<Task176962> list = new ArrayList<>();
        init(list, plans);

        list.sort(Comparator.comparingInt(o -> o.startTime));
        int startTime = list.get(0).startTime;
        int endTime = startTime + findEndTime(list);
        for (int i = startTime, j = 0; i < endTime; i++) {
            if (j == plans.length) {
                break;
            }
            if (i == list.get(j + 1).startTime) {
                j++;
            }
            list.get(j).setRemain(list.get(j).getRemain() - 1);
        }

        List<String> answer = new ArrayList<>();
        for (Task176962 task176962 : list) {
            if (task176962.getRemain() <= 0) {
                answer.add(task176962.getName());
            }
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).getRemain() > 0) {
                answer.add(list.get(i).getName());
            }
        }

        return answer.toArray(new String[plans.length]);
    }

    private int findEndTime(List<Task176962> list) {
        return list.stream().map(Task176962::getProgress).mapToInt(i -> i).sum();
    }

    private void init(List<Task176962> list, String[][] plans) {
        for (String[] plan : plans) {
            list.add(new Task176962(plan[0], covertTime(plan[1]), Integer.parseInt(plan[2])));
        }
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

