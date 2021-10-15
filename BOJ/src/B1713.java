import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Student2 {
    int index;
    int recommend;
    int time;

    public Student2(int index, int recommend, int time) {
        this.index = index;
        this.recommend = recommend;
        this.time = time;
    }
}

public class B1713 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = sc.nextInt();
        }
        ArrayList<Student2> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            //사진틀에 있는 경우
            boolean ok = true;
            for (Student2 student : list) {
                if (student.index == a[i]) {
                    student.recommend++;
                    ok = false;
                    break;
                }
            }
            //사진틀에 없는 경우
            if (ok) {
                //사진틀에 자리가 있다면
                if (list.size() < n) {
                    list.add(new Student2(a[i], 1, i));
                } else { //사진틀에 자리가 없다면
//                    Collections.sort(list, new Comparator<Student2>() {
//                        @Override
//                        public int compare(Student2 o1, Student2 o2) {
//                            if(o1.recommend < o2.recommend) {
//                                return -1;
//                            }
//                            else if (o1.recommend == o2.recommend) {
//                                if(o1.time < o2.time) {
//                                    return -1;
//                                }
//                                else if (o1.time == o2.time) {
//                                    return 0;
//                                }
//                                else {
//                                    return 1;
//                                }
//                            }
//                            else {
//                                return 1;
//                            }
//                        }
//                    });
                    Collections.sort(list,(o1, o2) -> {
                        if(o1.recommend < o2.recommend) {
                            return -1;
                        }
                        else if (o1.recommend == o2.recommend) {
                            if(o1.time < o2.time) {
                                return -1;
                            }
                            else if (o1.time == o2.time) {
                                return 0;
                            }
                            else {
                                return 1;
                            }
                        }
                        else {
                            return 1;
                        }
                    });
                    list.remove(0);
                    list.add(new Student2(a[i], 1, i));
                }
            }
        }
        Collections.sort(list, (o1, o2) -> o1.index - o2.index);
        for (Student2 student : list) {
            System.out.print(student.index + " ");
        }
    }
}

//Error
//예외케이스
//3
//15
//1 1 1 2 2 3 4 5 2 6 6 6 7 7 7
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Scanner;
//
//class Student2 {
//    int index;
//    int recommend;
//
//    public Student2(int index, int recommend) {
//        this.index = index;
//        this.recommend = recommend;
//    }
//}
//
//public class B1713 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int m = sc.nextInt();
//        int[] a = new int[m];
//        for (int i = 0; i < m; i++) {
//            a[i] = sc.nextInt();
//        }
//        ArrayList<Student2> list = new ArrayList<>();
//        for (int i = 0; i < m; i++) {
//            //사진틀에 있는 경우
//            boolean ok = true;
//            for (Student2 student : list) {
//                if (student.index == a[i]) {
//                    student.recommend++;
//                    ok = false;
//                    break;
//                }
//            }
//            //사진틀에 없는 경우
//            if (ok) {
//                //사진틀에 자리가 있다면
//                if (list.size() < n) {
//                    list.add(new Student2(a[i], 1));
//                } else { //사진틀에 자리가 없다면
//                    Collections.sort(list, (o1, o2) -> o1.recommend - o2.recommend);
//                    list.remove(0);
//                    list.add(new Student2(a[i], 1));
//                }
//            }
//        }
//        Collections.sort(list, (o1, o2) -> o1.index - o2.index);
//        for (Student2 student : list) {
//            System.out.print(student.index + " ");
//        }
//    }
//}