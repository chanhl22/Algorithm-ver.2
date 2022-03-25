package question;

class Solution53 {
    public int solution(String[] ings, String[] menu, String[] sell) {
        int answer = 0;
        String[][] in = new String[ings.length][2];
        for (int i = 0; i < ings.length; i++) {
            String[] str = ings[i].split(" ");
            in[i][0] = str[0];
            in[i][1] = str[1];
        }
        String[][] me = new String[menu.length][3];
        for (int i = 0; i < menu.length; i++) {
            String[] str = menu[i].split(" ");
            me[i][0] = str[0];
            me[i][1] = str[1];
            me[i][2] = str[2];
        }
        String[][] se = new String[sell.length][2];
        for (int i = 0; i < sell.length; i++) {
            String[] str = sell[i].split(" ");
            se[i][0] = str[0];
            se[i][1] = str[1];
        }

        String[][] cost = new String[menu.length][2];
        for (int i = 0; i < menu.length; i++) {
            cost[i][0] = me[i][0];
            int ret = 0;
            for (int j = 0; j < ings.length; j++) {
                for (int k = 0; k < me[i][1].length(); k++) {
                    if (in[j][0].charAt(0) == me[i][1].charAt(k)){
                        ret += Integer.parseInt(in[j][1]);
                    }
                }
            }
            cost[i][1] = Integer.toString(ret);
        }

        for (int i = 0; i < sell.length; i++) {
            for (int j = 0; j < cost.length; j++) {
                if (se[i][0].equals(cost[j][0])) {
                    answer += (Integer.parseInt(me[j][2]) - Integer.parseInt(cost[j][1])) * Integer.parseInt(se[i][1]);
                }
            }
        }

        return answer;
    }
}


public class WO3 {
    public static void main(String[] args) {
        Solution53 sol = new Solution53();
        int ans = 0;
//        ans = sol.solution(new String[]{"r 10", "a 23", "t 124", "k 9"},
//                new String[]{"PIZZA arraak 145", "HAMBURGER tkar 180", "BREAD kkk 30", "ICECREAM rar 50", "SHAVEDICE rar 45", "JUICE rra 55", "WATER a 20"},
//                new String[]{"BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1"}
//        );
        ans = sol.solution(new String[]{"x 25", "y 20", "z 1000"},
                new String[]{"AAAA xyxy 15", "TTT yy 30", "BBBB xx 30"},
                new String[]{"BBBB 3", "TTT 2"}
        );
        System.out.println(ans);
    }
}