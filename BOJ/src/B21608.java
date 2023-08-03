/**
 * playtime = 01:57:09
 */

import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int index;
    ArrayList<Integer> likeStudents;

    public Student(int index, ArrayList<Integer> likeStudent) {
        this.index = index;
        this.likeStudents = likeStudent;
    }

    public int getIndex() {
        return index;
    }

    public ArrayList<Integer> getLikeStudents() {
        return likeStudents;
    }
}

class Pair {
    int x;
    int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class B21608 {

    private static int n;
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final int[] dx = {0, 0, -1, 1};
    private static final int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) {
        input();
        int[][] seat = new int[n][n];

        updateSeat(seat);
    }

    private static void input() {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int totalStudent = n * n;
        while (totalStudent-- > 0) {
            int inputIndex = sc.nextInt();
            ArrayList<Integer> inputLikeStudents = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                inputLikeStudents.add(sc.nextInt());
            }
            students.add(new Student(inputIndex, inputLikeStudents));
        }
    }

    private static void updateSeat(int[][] seat) {
        for (int i = 0; i < n * n; i++) {
            Student student = students.get(i);
            ArrayList<Pair> possibleSeats = findPossibleSeats(seat, student.getLikeStudents());
            decideSeat(seat, possibleSeats, student.getIndex());
        }
        System.out.println(sumSatisfaction(seat));
    }

    private static int sumSatisfaction(int[][] seat) {
        int answer = 0;
        for (Student student : students) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (student.getIndex() == seat[i][j]) {
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                                if (student.getLikeStudents().contains(seat[nx][ny])) {
                                    count++;
                                }
                            }
                        }
                    }
                }
            }
            if (count == 0) {
                answer += 0;
            } else if (count == 1) {
                answer += 1;
            } else if (count == 2) {
                answer += 10;
            } else if (count == 3) {
                answer += 100;
            } else {
                answer += 1000;
            }
        }
        return answer;
    }

    private static ArrayList<Pair> findPossibleSeats(int[][] seat, ArrayList<Integer> likeStudents) {
        ArrayList<Pair> possibleSeats = new ArrayList<>();
        if (noLikeStudent(seat, likeStudents)) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (seat[i][j] == 0) {
                        possibleSeats.add(new Pair(i, j));
                    }
                }
            }
        } else {
            int[][] countLikeStudent = new int[n][n];
            int maxLikeStudent = 0;
            for (int studentIndex : likeStudents) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (seat[i][j] == studentIndex) {
                            for (int k = 0; k < 4; k++) {
                                int nx = i + dx[k];
                                int ny = j + dy[k];
                                if (nx >= 0 && nx < n && ny >= 0 && ny < n && seat[nx][ny] == 0) {
                                    countLikeStudent[nx][ny]++;
                                    if (maxLikeStudent < countLikeStudent[nx][ny]) {
                                        maxLikeStudent = countLikeStudent[nx][ny];
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (countLikeStudent[i][j] == maxLikeStudent && seat[i][j] == 0) {
                        possibleSeats.add(new Pair(i, j));
                    }
                }
            }
        }

        possibleSeats.sort((o1, o2) -> {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        });
        return possibleSeats;
    }

    private static boolean noLikeStudent(int[][] seat, ArrayList<Integer> likeStudents) {
        for (int likeStudent : likeStudents) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (seat[i][j] == likeStudent) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private static void decideSeat(int[][] seat, ArrayList<Pair> possibleSeats, int studentIndex) {
        int findX = 0;
        int findY = 0;
        int emptyCount = -1;
        for (Pair possibleSeat : possibleSeats) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (possibleSeat.getX() == i && possibleSeat.getY() == j) {
                        int tempCount = 0;
                        for (int k = 0; k < 4; k++) {
                            int nx = i + dx[k];
                            int ny = j + dy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n && seat[nx][ny] == 0) {
                                tempCount++;
                            }
                        }
                        if (emptyCount == -1 || emptyCount < tempCount) {
                            emptyCount = tempCount;
                            findX = i;
                            findY = j;
                        }
                    }
                }
            }
        }
        seat[findX][findY] = studentIndex;
    }
}