package question;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair10 {
    int first;
    int second;

    public Pair10(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution109 {
    static int n;

    public int solution(int[] numbers, int k) {
        int answer = Integer.MAX_VALUE;
        n = numbers.length;
        int[] change_numbers = new int[n];
        for (int i = 0; i < n; i++) {
            change_numbers[i] = numbers[i];
        }
        Arrays.sort(change_numbers);
        if (!calc_diff(change_numbers, k)) {
            return -1;
        }
        do {
            if (calc_diff(change_numbers, k)) { //차이를 만족?
                int count = compare(numbers, change_numbers); //달라진 배열 체크
                if (count < answer) {
                    answer = count;
                }
            }
        } while (next(change_numbers));
        return answer;
    }

    private boolean calc_diff(int[] change_numbers, int k) {
        boolean ok = true;
        for (int i = 1; i < n; i++) {
            if (Math.abs(change_numbers[i-1] - change_numbers[i]) > k) {
                ok = false;
            }
        }
        return ok;
    }

    private int compare(int[] numbers, int[] change_numbers) {
        Pair10[] pair = new Pair10[n];
        for (int i = 0; i < n; i++) {
            pair[i] = new Pair10(numbers[i], change_numbers[i]);
        }
        int count = 0;
        boolean[] visited = new boolean[101];
        for (int i = 0; i < n; i++) {
            if (visited[numbers[i]] == true) {
                continue;
            }
            int temp_count = 0;
            visited[pair[i].first] = true;
            Queue<Pair10> q = new LinkedList<>();
            q.add(new Pair10(pair[i].first, pair[i].second));
            while (!q.isEmpty()) {
                Pair10 p = q.remove();
                int next = p.second;
                if (visited[next] == false) {
                    int index = 0;
                    for (int j = 0; j < n; j++) {
                        if (pair[j].first == next) {
                            index = j;
                        }
                    }
                    q.add(new Pair10(pair[index].first, pair[index].second));
                    visited[next] = true;
                    temp_count++;
                }
            }
            if (temp_count == 1) {
                count++;
            } else if (temp_count > 1) {
                count += temp_count;
            }
        }
        return count;
    }


    static boolean next(int[] d) {
        int i = d.length - 1;
        while (i > 0 && d[i] <= d[i - 1]) {
            i--;
        }
        if (i <= 0) {
            return false;
        }

        int j = d.length - 1;
        while (d[i - 1] >= d[j]) {
            j--;
        }

        int temp = d[i - 1];
        d[i - 1] = d[j];
        d[j] = temp;

        j = d.length - 1;
        while (i < j) {
            temp = d[j];
            d[j] = d[i];
            d[i] = temp;
            i++;
            j--;
        }
        return true;
    }
}


public class SO_22_2 {
    public static void main(String[] args) {
        Solution109 sol = new Solution109();
        int ans = 0;
//        ans = sol.solution(new int[]{10, 40, 30, 20}, 20);
//        ans = sol.solution(new int[]{3, 7, 2, 8, 6, 4, 5, 1}, 3);
//        ans = sol.solution(new int[]{1, 5, 3}, 2);
        ans = sol.solution(new int[]{1, 5, 7}, 2);
        System.out.println(ans);
    }
}