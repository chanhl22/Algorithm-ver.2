import java.util.ArrayList;
import java.util.Scanner;

public class B4641 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            ArrayList<Integer> a = new ArrayList<>();
            while(true) {
                int num = sc.nextInt();
                if (num == 0) {
                    break;
                } else if (num == -1) {
                    System.exit(0);
                }
                a.add(num);
            }
            int cnt = 0;
            for (int i = 0; i < a.size(); i++) {
                for (int j = 0; j < a.size(); j++) {
                    if (a.get(i) * 2 == a.get(j)) {
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}

//Another Solution
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//public class Doubles {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        List<Integer> list = new ArrayList<>();
//        int num;
//        int cnt = 0;
//        while (true) {
//            num = sc.nextInt();
//            if (num == -1) break;
//            if (num == 0) {
//                for (int i = 0; i < list.size(); i++) {
//                    for (int j = 0; j < list.size(); j++) {
//                        if (i != j && list.get(i) * 2 == list.get(j)) cnt++;
//                    }
//                }
//                System.out.println(cnt);
//                list.clear();
//                cnt = 0;
//            } else {
//                list.add(num);
//            }
//        }
//    }
//}