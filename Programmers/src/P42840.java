import java.util.ArrayList;

class Solution9 {
    public int[] solution(int[] answers) {
        ArrayList<Integer> array = new ArrayList<>();
        int n = answers.length;
        int[] a = new int[n];
        int[] b = new int[n];
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = (i % 5) + 1;
        }
        for (int i = 0; i < n; i++) {
            b[i] = 2;
            if (i % 8 == 1) {
                b[i] = 1;
            } else if (i % 8 == 3) {
                b[i] = 3;
            } else if (i % 8 == 5) {
                b[i] = 4;
            } else if (i % 8 == 7) {
                b[i] = 5;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i % 10 == 0 || i % 10 == 1) {
                c[i] = 3;
            } else if (i % 10 == 2 || i % 10 == 3) {
                c[i] = 1;
            } else if (i % 10 == 4 || i % 10 == 5) {
                c[i] = 2;
            } else if (i % 10 == 6 || i % 10 == 7) {
                c[i] = 4;
            } else if (i % 10 == 8 || i % 10 == 9) {
                c[i] = 5;
            }
        }
        int ans1 = 0;
        int ans2 = 0;
        int ans3 = 0;
        for (int i = 0; i < n; i++) {
            if (answers[i] == a[i]) {
                ans1 += 1;
            }
            if (answers[i] == b[i]) {
                ans2 += 1;
            }
            if (answers[i] == c[i]) {
                ans3 += 1;
            }
        }

        if (ans1 > ans2 && ans1 > ans3) {
            array.add(1);
        } else if (ans2 > ans1 && ans2 > ans3) {
            array.add(2);
        } else if (ans3 > ans1 && ans3 > ans2) {
            array.add(3);
        } else if (ans1 == ans2 && ans2 == ans3){
            array.add(1);
            array.add(2);
            array.add(3);
        }else if (ans1 == ans2){
            array.add(1);
            array.add(2);
        }else if (ans2 == ans3){
            array.add(2);
            array.add(3);
        }else if (ans1 == ans3){
            array.add(1);
            array.add(3);
        }
        int[] answer = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            answer[i] = array.get(i);
        }
        return answer;
    }
}


public class P42840 {
    public static void main(String[] args) {
        Solution9 sol = new Solution9();
        int[] ans = {};
        //ans = sol.solution(new int[]{1, 2, 3 , 4, 5});
        ans = sol.solution(new int[]{1, 3, 2 , 4, 2});
        //ans = sol.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        System.out.println(ans);
    }
}