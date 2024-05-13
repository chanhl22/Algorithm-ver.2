/**
 * playtime = 46m 44s
 * 풀이횟수 = 2
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class P138476 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int ans = 0;
//        ans = sol.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
        ans = sol.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
//        ans = sol.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3});
        System.out.println(ans);
    }

    static class Fruit {
        int size;
        long count;

        public Fruit(int size, long count) {
            this.size = size;
            this.count = count;
        }

        public long getCount() {
            return count;
        }
    }

    static class Solution {
        public int solution(int k, int[] tangerine) {
            int answer = 0;
            List<Fruit> fruits = initFruit(tangerine);

            for (Fruit fruit : fruits) {
                k -= fruit.count;
                answer++;
                if (k <= 0) {
                    break;
                }
            }
            return answer;
        }

        private List<Fruit> initFruit(int[] tangerine) {
            Map<Integer, Long> map = Arrays.stream(tangerine)
                    .boxed()
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            return map.entrySet().stream()
                    .map(entry -> new Fruit(entry.getKey(), entry.getValue()))
                    .sorted(Comparator.comparing(Fruit::getCount, Comparator.reverseOrder()))
                    .collect(Collectors.toList());
        }
    }
}

/**
 * playtime = 28:02

import java.util.ArrayList;
import java.util.HashMap;

class Fruit138476 {
    int size;
    int count;

    public Fruit138476(int size, int count) {
        this.size = size;
        this.count = count;
    }
}

class Solution138476 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        ArrayList<Fruit138476> fruits = initFruit(tangerine);

        fruits.sort((o1, o2) -> o2.count - o1.count);
        for (Fruit138476 fruit : fruits) {
            k -= fruit.count;
            answer++;
            if (k <= 0) {
                break;
            }
        }
        return answer;
    }

    private ArrayList<Fruit138476> initFruit(int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        ArrayList<Fruit138476> fruits = new ArrayList<>();
        for (Integer key : map.keySet()) {
            Integer value = map.get(key);
            fruits.add(new Fruit138476(key, value));
        }
        return fruits;
    }
}

public class P138476 {
    public static void main(String[] args) {
        Solution138476 sol = new Solution138476();
        int ans = 0;
//        ans = sol.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
        ans = sol.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3});
//        ans = sol.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3});
        System.out.println(ans);
    }
}
 */