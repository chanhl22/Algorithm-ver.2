import java.util.Scanner;

public class B1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str.equals(" ")){ //공백 하나만이 입력으로 주어질 때 s는 길이가 0인 배열이 되어 s[0]이 존재하지 않게 됩니다.
            System.out.println(0);
            System.exit(0);
        }
        String[] a = str.split(" ");
        if (a[0].equals("")) {
            System.out.println(a.length-1);
        } else {
            System.out.println(a.length);
        }
    }
}

//Code Refactoring
//import java.util.Scanner;
//
//public class Main {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String input = sc.nextLine().trim();
//		sc.close();
//
//		if (input.isEmpty()) {
//			System.out.println(0);
//		} else {
//			System.out.println(input.split(" ").length);
//		}
//	}
//}