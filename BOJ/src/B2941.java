import java.util.Scanner;

public class B2941 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        a = a.replace("c=", "A");
        a = a.replace("c-", "B");
        a = a.replace("dz=", "C");
        a = a.replace("d-", "D");
        a = a.replace("lj", "E");
        a = a.replace("nj", "F");
        a = a.replace("s=", "G");
        a = a.replace("z=", "H");
        System.out.println(a.length());
    }
}
