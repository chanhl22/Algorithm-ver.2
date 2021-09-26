import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class B1655 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            if (i % 2 == 0) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                if (minHeap.peek() < maxHeap.peek()){
                    int temp = minHeap.poll();
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(temp);
                }
            }
            sb.append(maxHeap.peek() + "\n");
        }
        System.out.println(sb.toString());
    }
}

//Time out
//import java.util.Arrays;
//import java.util.Scanner;
//
//public class B1655 {
//    static int go(int count, int[] num) {
//        int ans = 0;
//        int[] record = new int[count + 1];
//        for (int i = 0; i <= count; i++) {
//            record[i] = num[i];
//        }
//        Arrays.sort(record);
//        ans = record[count/2];
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] num = new int[n];
//        for (int i = 0; i < n; i++) {
//            num[i] = sc.nextInt();
//            System.out.println(go(i, num));
//        }
//    }
//}
