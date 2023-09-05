/**
 * playtime = 29:34
 */

import java.util.ArrayList;
import java.util.Scanner;

class Team2852 {
    int number;
    String inputTime;
    int time;

    public Team2852(int number, String inputTime) {
        this.number = number;
        this.inputTime = inputTime;
        String[] split = inputTime.split(":");
        this.time = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}

class TeamA2852 {
    int score;
    int winTime;
}

class TeamB2852 {
    int score;
    int winTime;
}

public class B2852 {
    private static final ArrayList<Team2852> info = new ArrayList<>();
    private static final int PLAYTIME = 2880;

    public static void main(String[] args) {
        input();
        solution();
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            info.add(new Team2852(sc.nextInt(), sc.next()));
        }
    }

    private static void solution() {
        TeamA2852 teamA = new TeamA2852();
        TeamB2852 teamB = new TeamB2852();
        for (int i = 0, j = 0; i < PLAYTIME; i++) {
            if (j < info.size() && info.get(j).time == i) {
                if (info.get(j).number == 1) {
                    teamA.score++;
                } else {
                    teamB.score++;
                }
                j++;
            }
            if (teamA.score > teamB.score) {
                teamA.winTime++;
            } else if (teamA.score < teamB.score) {
                teamB.winTime++;
            }
        }

        System.out.println(makeTwoDigits(teamA.winTime / 60) + ":" + makeTwoDigits(teamA.winTime % 60));
        System.out.println(makeTwoDigits(teamB.winTime / 60) + ":" + makeTwoDigits(teamB.winTime % 60));
    }

    private static String makeTwoDigits(int num) {
        String s = String.valueOf(num);
        if (s.length() == 1) {
            return 0 + s;
        }
        return s;
    }
}
