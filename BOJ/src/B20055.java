//playtime = 02:05:39

import java.util.Scanner;

public class B20055 {
    static int n;
    static int k;
    static int[] container;
    static int[] boxPosition;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        container = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            container[i] = sc.nextInt();
        }

        boxPosition = new int[2 * n];
        int count = 0;
        while (true) {
            rotate(container);
            rotate(boxPosition);

            if (boxPosition[n - 1] == 1) {
                boxPosition[n - 1] = 0;
            }
            for (int i = n - 2; i >= 0; i--) {
                if (boxPosition[i] == 1) {
                    if (container[i + 1] != 0 && boxPosition[i + 1] != 1) {
                        boxPosition[i + 1] = 1;
                        if (i + 1 == n - 1) {
                            boxPosition[i + 1] = 0;
                        }
                        boxPosition[i] = 0;
                        container[i + 1] -= 1;
                    }
                }
            }

            if (container[0] != 0) {
                boxPosition[0] = 1;
                container[0] -= 1;
            }

            count++;
            if (finish()) {
                break;
            }
        }
        System.out.println(count);
    }

    private static void rotate(int[] arr) {
        int temp = arr[2 * n - 1];
        for (int i = 2 * n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;
    }

    private static boolean finish() {
        int count = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (container[i] == 0) {
                count++;
            }
        }
        if (count >= k) {
            return true;
        }
        return false;
    }

}

//Another Solution
//import java.util.Scanner;
//
//public class B20055 {
//    static void rotate(int[] a) {
//        int temp = a[a.length-1];
//        for (int i=a.length-1; i>0; i--) {
//            a[i] = a[i-1];
//        }
//        a[0] = temp;
//    }
//	public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[] a = new int[2*n];
//        for (int i=0; i<2*n; i++) {
//            a[i] = sc.nextInt();
//        }
//        int[] box = new int[2*n];
//        int zero = 0;
//        for (int t=1;; t++) {
//            rotate(a);
//            rotate(box);
//            if (box[n-1] == 1) {
//                box[n-1] = 0;
//            }
//            for (int i=n-2; i>=0; i--) {
//                if (box[i] == 1) {
//                    if (box[i+1] == 0 && a[i+1] > 0) {
//                        box[i+1] = 1;
//                        box[i] = 0;
//                        a[i+1] -= 1;
//                        if (a[i+1] == 0) {
//                            zero += 1;
//                        }
//                    }
//                }
//            }
//            if (box[n-1] == 1) {
//                box[n-1] = 0;
//            }
//            if (a[0] > 0) {
//                box[0] = 1;
//                a[0] -= 1;
//                if (a[0] == 0) {
//                    zero += 1;
//                }
//            }
//            if (zero >= k) {
//                System.out.println(t);
//                break;
//            }
//        }
//    }
//}