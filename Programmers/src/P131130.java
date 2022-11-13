//playtime = 01:08:34
//다시 풀어야 함

import java.util.ArrayList;

class Solution131130 {
    public int solution(int[] cards) {
        int len = cards.length;
        boolean[] checked = new boolean[len];
        ArrayList<Integer> sizeArray = new ArrayList<>();
        while (!checkAllTrue(checked)) {
            sizeArray.add(findOpenBox(cards, checked));
        }
        sizeArray.sort((o1, o2) -> o2 - o1);
        if (sizeArray.size() <= 1) {
            return 0;
        } else {
            return sizeArray.get(0) * sizeArray.get(1);
        }
    }

    private Integer findOpenBox(int[] cards, boolean[] checked) {
        int min = findMin(cards, checked);
        int tempMin = min;
        int count = 1;
        while(true) {
            min = findNextBox(min, cards, checked);
            if (min != tempMin) {
                count++;
            }
            if (checked[min]) {
                break;
            }
        }
        return count;
    }

    private Integer findNextBox(int min, int[] cards, boolean[] checked) {
        checked[min] = true;
        return cards[min] - 1;
    }

    private int findMin(int[] cards, boolean[] checked) {
        int min = -1;
        int minIndex = 0;
        for (int i = 0; i < cards.length; i++) {
            if (min == -1 || min > cards[i]) {
                if (!checked[i]) {
                    min = cards[i];
                    minIndex = i;
                }
            }
        }
        checked[minIndex] = true;
        return min - 1;
    }

    private boolean checkAllTrue(boolean[] checked) {
        boolean ok = true;
        for (boolean b : checked) {
            if (!b) {
                ok = false;
                break;
            }
        }
        return ok;
    }
}

public class P131130 {
    public static void main(String[] args) {
        Solution131130 sol = new Solution131130();
//        int ans = sol.solution(new int[]{8, 6, 3, 7, 2, 5, 1, 4});
//        int ans = sol.solution(new int[]{1, 2});
        int ans = sol.solution(new int[]{10, 3, 2});
        System.out.println(ans);
    }
}