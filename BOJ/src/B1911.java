//playtime = 28:48

//Refactoring 완료
import java.util.Arrays;
import java.util.Scanner;

public class B1911 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[][] pool = new int[n][2];
        for (int i = 0; i < n; i++) {
            pool[i][0] = sc.nextInt();
            pool[i][1] = sc.nextInt();
        }
        Arrays.sort(pool, (o1, o2) -> o1[0] - o2[0]);
        int endPoint = 0;
        int count = 0;
        int index = 0;
        while (index < n) {
            if (endPoint < pool[index][0]) {
                endPoint = pool[index][0];
            } else {
                endPoint += l;
                count++;
            }
            while (index < n && endPoint >= pool[index][1]) {
                index++;
            }
        }
        System.out.println(count);
    }
}

//import java.util.Arrays;
//import java.util.Scanner;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int l = sc.nextInt();
//        int[][] pool = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            pool[i][0] = sc.nextInt();
//            pool[i][1] = sc.nextInt();
//        }
//        Arrays.sort(pool, (o1, o2) -> o1[0] - o2[0]);
//        int endPoint = 0;
//        int count = 0;
//        int index = 0;
//        while (index < n) {
//            if (endPoint >= pool[index][1]) {
//                index++;
//                continue;
//            }
//            if (endPoint < pool[index][0]) {
//                endPoint = pool[index][0];
//            } else {
//                endPoint += l;
//                count++;
//            }
//            if (endPoint >= pool[index][1]) {
//                index++;
//            }
//        }
//        System.out.println(count);
//    }
//}