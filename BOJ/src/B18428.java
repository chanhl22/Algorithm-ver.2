import java.util.ArrayList;
import java.util.Scanner;

public class B18428 {
    static ArrayList<Integer> teacher;
    static int n;

    static boolean cal (char[][] check) {
        for (int i = 0; i < teacher.size(); i+=2) {
            int x = teacher.get(i);
            int y = teacher.get(i+1);
            while (x-- >= 0) {
                if (x >= 0 && x < n && y >= 0 && y < n) {
                    if (check[x][y] == 'O') break;
                    if (check[x][y] == 'S') return false;
                }
            }
            x = teacher.get(i);
            y = teacher.get(i+1);
            while (x++ < n) {
                if (x >= 0 && x < n && y >= 0 && y < n) {
                    if (check[x][y] == 'O') break;
                    if (check[x][y] == 'S') return false;
                }
            }
            x = teacher.get(i);
            y = teacher.get(i+1);
            while (y-- >= 0) {
                if (x >= 0 && x < n && y >= 0 && y < n) {
                    if (check[x][y] == 'O') break;
                    if (check[x][y] == 'S') return false;
                }
            }
            x = teacher.get(i);
            y = teacher.get(i+1);
            while (y++ < n) {
                if (x >= 0 && x < n && y >= 0 && y < n) {
                    if (check[x][y] == 'O') break;
                    if (check[x][y] == 'S') return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        char[][] a = new char[n][n];
        teacher = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.next().charAt(0);
                if (a[i][j] == 'T') {
                    teacher.add(i);
                    teacher.add(j);
                }
            }
        }
        char[] arr = new char[n * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[index] = a[i][j];
                index++;
            }
        }
        for (int i = 0; i < n * n; i++) {
            if (arr[i] != 'X') continue;
            for (int j = i + 1; j < n * n; j++) {
                if (arr[j] != 'X') continue;
                for (int k = j + 1; k < n * n; k++) {
                    if (arr[k] != 'X') continue;
                    char[] temp = new char[n*n];
                    for (int l = 0; l < n*n; l++) {
                        temp[l] = arr[l];
                    }
                    temp[i] = 'O';
                    temp[j] = 'O';
                    temp[k] = 'O';
                    char[][] check = new char[n][n];
                    for (int l = 0; l < n; l++) {
                        for (int m = 0; m < n; m++) {
                            check[l][m] = temp[l * n + m];
                        }
                    }
                    boolean ok = cal(check);
                    if (ok) {
                        System.out.println("YES");
                        System.exit(0);
                    }
                }
            }
        }
        System.out.println("NO");
    }
}
