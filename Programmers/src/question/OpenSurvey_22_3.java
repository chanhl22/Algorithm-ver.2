package question;

import java.util.TreeSet;

/**
 * 1 -> 1개
 * 3 4 -> 2개
 * 9 10 12 13 -> 4개
 * 27 28 30 31 36 37 39 40 -> 8개
 * 81
 */

class Solution125 {

    /**
     * 이것도 n이 최대인 경우를 구할 수 없음
     */
    public static long solution(int n) {
        n++;
        TreeSet<Long> combinations = generateCombinations();

        // TreeSet은 정렬된 상태를 유지하기 때문에, n번째 요소를 바로 찾을 수 있습니다.
        int index = 0;
        for (long number : combinations) {
            index++;
            if (index == n) {
                return number;
            }
        }
        return -1;  // 만약 n이 범위를 벗어난 경우
    }

    public static TreeSet<Long> generateCombinations() {
        long limit = (long) Math.pow(10, 10); // 충분히 큰 값으로 제한 설정
        TreeSet<Long> powers = new TreeSet<>();
        TreeSet<Long> combinations = new TreeSet<>();
        combinations.add(0L); // 0은 아무것도 선택하지 않은 상태를 나타냄

        long power = 1;
        while (power <= limit) {
            powers.add(power);
            power *= 3;
        }

        for (long p : powers) {
            TreeSet<Long> newCombinations = new TreeSet<>();
            for (long existing : combinations) {
                newCombinations.add(existing + p);
            }
            combinations.addAll(newCombinations);
        }

        return combinations;
    }

    /**
     * 100억번 반복이라서 불가능
    public static long solution(long n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.offer(1L);
        long prev = 0;

        for (long i = 0; i < n; i++) {
            long current = pq.poll();
            if (current == prev) { // 같은 숫자를 두 번 이상 더할 수 없도록 합니다.
                i--;
                continue;
            }
            prev = current;
            pq.offer(current * 3 + 1);
            pq.offer(current * 3);
        }

        return prev;
    }
     */

}

public class OpenSurvey_22_3 {
    public static void main(String[] args) {
        Solution125 sol = new Solution125();
        System.out.println("sol = " + sol.solution(1)); // 1
        System.out.println("sol = " + sol.solution(2)); // 3
        System.out.println("sol = " + sol.solution(3)); // 4
        System.out.println("sol = " + sol.solution(4)); // 9
        System.out.println("sol = " + sol.solution(5)); // 10
        System.out.println("sol = " + sol.solution(6)); // 12
        System.out.println("sol = " + sol.solution(7)); // 13
        System.out.println("sol = " + sol.solution(8)); // 27
        System.out.println("sol = " + sol.solution(9)); // 28
        System.out.println("sol = " + sol.solution(11)); //31
//        System.out.println("sol = " + sol.solution(10000000000L)); //31
    }
}