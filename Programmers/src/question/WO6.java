package question;

class Solution56 {
    public String solution(double time, String[][] plans) {
        String answer = "호치민";
        for (int i = 0; i < plans.length; i++) {
            String temp = plans[i][1].substring(plans[i][1].length() - 2);
            if (temp.equals("PM")) {
                String start = plans[i][1].replace("PM", "");
                if (Integer.parseInt(start) < 6) {
                    time -= Double.parseDouble(start);
                }
            } else {
                String start = plans[i][1].replace("AM", "");
                time -= (12 - Double.parseDouble(start)) + 6;
            }

            temp = plans[i][2].substring(plans[i][2].length() - 2);
            if (temp.equals("PM")) {
                String end = plans[i][2].replace("PM", "");
                if (Integer.parseInt(end) > 1) {
                    time -= Double.parseDouble(end);
                }
            }

            if (time >= 0) {
                answer = plans[i][0];
            }
        }
        return answer;
    }
}


public class WO6 {
    public static void main(String[] args) {
        Solution56 sol = new Solution56();
        //String ans = sol.solution(3.5, new String[][]{{"홍콩", "11PM", "9AM"}, {"엘에이", "3PM", "2PM"}});
        //String ans = sol.solution(3.5, new String[][]{{"홍콩", "11AM", "9AM"}, {"엘에이", "3PM", "2PM"}});
        String ans = sol.solution(3.5, new String[][]{{"홍콩", "3PM", "9AM"}, {"엘에이", "6PM", "1PM"}});
        System.out.println(ans);
    }
}