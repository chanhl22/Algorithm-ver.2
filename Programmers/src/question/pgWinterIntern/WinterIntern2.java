package question.pgWinterIntern;

import java.util.ArrayList;
import java.util.List;

class PGMember {
    int member;
    int money;
    int group;

    public PGMember(int member, int money, int group) {
        this.member = member;
        this.money = money;
        this.group = group;
    }

    public int getMember() {
        return member;
    }

    public int getMoney() {
        return money;
    }

    public int getGroup() {
        return group;
    }

    public void setMember(int member) {
        this.member = member;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void setGroup(int group) {
        this.group = group;
    }
}

class SolutionWinterIntern2 {

    public static int TOP_GROUP = 0;
    public static int BOTTOM_GROUP = 1;

    public int solution(int total, int[] memberSeq, int[] money) {
        int answer = 0;

        List<PGMember> members = init(total);
        for (int i = 0; i < memberSeq.length; i++) {
            updateMoney(total, memberSeq, money, members, i);
            members.sort((o1, o2) -> o2.money - o1.money);
            if (checkTopGroupAndUpdateGroup(members, total)) {
                answer++;
            }
        }

        return answer - 1;
    }

    private List<PGMember> init(int total) {
        List<PGMember> members = new ArrayList<>();
        for (int i = 0; i < total / 2; i++) {
            members.add(new PGMember(i + 1, 0, TOP_GROUP));
        }
        for (int i = total / 2; i < total; i++) {
            members.add(new PGMember(i + 1, 0, BOTTOM_GROUP));
        }
        return members;
    }

    private boolean checkTopGroupAndUpdateGroup(List<PGMember> members, int total) {
        boolean flag = false;
        for (int i = 0; i < total / 2; i++) {
            if (members.get(i).getGroup() == BOTTOM_GROUP) {
                flag = true;
            }
            members.get(i).setGroup(TOP_GROUP);
        }
        for (int i =  total / 2; i < total; i++) {
            members.get(i).setGroup(BOTTOM_GROUP);
        }
        return flag;
    }

    private void updateMoney(int total, int[] memberSeq, int[] money, List<PGMember> members, int i) {
        for (int j = 0; j < total; j++) {
            if (members.get(j).getMember() == memberSeq[i]) {
                members.get(j).setMoney(money[i]);
            }
        }
    }
}

public class WinterIntern2 {
    public static void main(String[] args) {
        SolutionWinterIntern2 sol = new SolutionWinterIntern2();
        int ans = sol.solution(6, new int[]{6, 1, 4, 2, 5, 1, 3, 3, 1, 6, 5}, new int[]{3, 2, 5, 3, 4, 2, 4, 2, 3, 2, 2}); //7
        System.out.println(ans);
    }
}