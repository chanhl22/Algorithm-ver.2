import java.util.Scanner;

public class B1107 {
	static boolean[] broken = new boolean[10];
	
	static int possible(int c) {
		int len = 0;
		
		if (c == 0) {
			return broken[0] ? 0 : 1;
		}
		while(c > 0) {
			if(broken[c % 10])
				return 0;
			len += 1;
			c /= 10;
		}
		return (len);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int channel = sc.nextInt();
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			int button = sc.nextInt();
			broken[button] = true;
		}
		int res = channel - 100;
		if (res < 0)
			res = -res;
		for (int i = 0; i < 1000000; i++) {
			int c = i;
			int len = possible(c);
			if (len > 0) {
				int plusminus = c - channel;
				if (plusminus < 0)
					plusminus = -plusminus;
				if (res > len + plusminus) {
					res = len + plusminus;
				}
			}
		}
		System.out.println(res);
	}

}
