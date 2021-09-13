import java.util.ArrayList;

class Solution2 {
    static int up(String s, boolean[] check, int k, boolean[] check_del) {
        String[] array = s.split(" ");
        int point = Integer.parseInt(array[1]);
        check[k] = false;
        while (--k > 0){
            if(check_del[k]){
                point--;
            }
            if (point == 0){
                check[k] = true;
                break;
            }
        }
        return k;
    }

    static int down(String s, boolean[] check, int k, boolean[] check_del, int n) {
        String[] array = s.split(" ");
        int point = Integer.parseInt(array[1]);
        check[k] = false;
        while (++k < n){
            if(check_del[k]){
                point--;
            }
            if (point == 0){
                check[k] = true;
                break;
            }
        }
        return k;
    }

    static int delete_select_down(boolean[] check, int k, int n, boolean[] check_del, ArrayList<Integer> r) {
        check_del[k] = false;
        r.add(k);
        check[k] = false;
        if (k + 1 >= n) {
            for (int i = k - 1; i > 0; i--) {
                if (check_del[i] == false) {
                    continue;
                } else {
                    check[i] = true;
                    k = i;
                    break;
                }
            }
        } else {
            for (int i = k + 1; i < n; i++) {
                if (check_del[i] == false) {
                    continue;
                } else {
                    check[i] = true;
                    k = i;
                    break;
                }
            }
        }
        return k;
    }

    static void rewind(boolean[] check_del, ArrayList<Integer> r) {
        int point = r.remove(r.size() - 1);
        check_del[point] = true;
    }

    public String solution(int n, int k, String[] cmd) {
        String answer = "";
        char[] arr = new char[n]; //output array
        boolean[] check = new boolean[n]; //current location check
        check[k] = true; //start point
        boolean[] check_del = new boolean[n]; //check delete
        for (int i = 0; i < n; i++) {
            check_del[i] = true;
        }
        ArrayList<Integer> r = new ArrayList<>();
        for (int i = 0; i < cmd.length; i++) {
            if (cmd[i].indexOf('U') != -1) {
                k = up(cmd[i], check, k, check_del);
            } else if (cmd[i].indexOf('D') != -1) {
                k = down(cmd[i], check, k, check_del, n);
            } else if (cmd[i].indexOf('C') != -1) {
                k = delete_select_down(check, k, n, check_del, r);
            } else if (cmd[i].indexOf('Z') != -1) {
                rewind(check_del, r);
            }
        }
//        System.out.println("현재 위치");
//        for (int i = 0; i < n; i++) {
//            System.out.print(check[i] + " ");
//        }
//        System.out.println();
//        System.out.println("사라진 배열");
//        for (int i = 0; i < n; i++) {
//            System.out.print(check_del[i] + " ");
//        }
//        System.out.println();

        for (int i = 0; i < n; i++) {
            if (check_del[i]){
                arr[i] = 'O';
            } else {
                arr[i] = 'X';
            }
        }
        answer = String.valueOf(arr);

        return answer;
    }
}

public class K81303 {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
//        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        String[] cmd2 = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1","C"};
//        String[] cmd2 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
//        String ans = sol.solution(8, 2, cmd);
//        String[] cmd = {"U 2", "C"};
//        String ans = sol.solution(3, 2, cmd);
//        System.out.println(ans);
        String ans = sol.solution(8, 2, cmd2);
        System.out.println(ans);
    }
}
