import java.util.Scanner;

public class B11726 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] d = new int[1001];
        d[0] = 1;
        d[1] = 1;
        for (int i=2; i<=n; i++) {
            d[i] = d[i-1] + d[i-2];
            d[i] %= 10007;
        }
        System.out.println(d[n]);
    }
}

//import java.util.*;
//
//public class Main{
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//
//        int[] arr = new int[n+1];
//
//        for(int i=0;i<=n;i++){
//            if(i<3){
//                arr[i]=i;
//            }else {
//                arr[i] = arr[i - 1] + arr[i - 2];
//                arr[i] %= 10007;
//            }
//        }
//        System.out.println(arr[n]);
//    }
//}