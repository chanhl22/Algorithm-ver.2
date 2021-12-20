//playtime = 44:32

import java.util.*;

class High {
    int index;
    int high;

    public High(int index, int high) {
        this.index = index;
        this.high = high;
    }
}

public class B2304 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        High[] h = new High[n];
        int max_index = 0;
        int max_high = 0;
        for (int i = 0; i < n; i++) {
            int index = sc.nextInt();
            int high = sc.nextInt();
            h[i] = (new High(index, high));
            if (max_high < high) {
                max_high = high;
                max_index = index;
            }
        }
        Arrays.sort(h, (o1, o2) -> o1.index - o2.index);
        int position = 0;
        for (int i = 0; i < n; i++) {
            if (max_index == h[i].index) {
                position = i;
            }
        }
        Queue<High> front = new LinkedList<>();
        Queue<High> back = new LinkedList<>();
        for (int i = 0; i <= position; i++) {
            front.add(h[i]);
        }
        for (int i = n-1; i > position; i--) {
            back.add(h[i]);
        }

        //정답 구하기
        int ans = 0;
        int cur = 0;
        for (int i = h[0].index; i <= max_index; i++) {
            if (!front.isEmpty()) {
                if (front.peek().index == i) {
                    High temp = front.remove();
                    if (cur < temp.high) {
                        cur = temp.high;
                    }
                }
            }
            ans += cur;
        }
        cur = 0;
        for (int i = h[n - 1].index; i > max_index; i--) {
            if (!back.isEmpty()) {
                if (back.peek().index == i) {
                    High temp = back.remove();
                    if (cur < temp.high) {
                        cur = temp.high;
                    }
                }
            }
            ans += cur;
        }
        System.out.println(ans);
    }
}

//Best Solution
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.StringTokenizer;
//
//public class Back_2304 {
//
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		ArrayList<top> arr = new ArrayList<>();
//		int ans=0;
//
//		StringTokenizer st;
//		for (int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine());
//			int x = Integer.parseInt(st.nextToken());
//			int y = Integer.parseInt(st.nextToken());
//			arr.add(new top(x, y));
//		}
//		Collections.sort(arr);
//
//		int maxX=0;
//
//		//오른쪽에서 왼쪽으로
//		top currenttop=arr.get(0);
//		for (int i = 1; i < N; i++) {
//			if(currenttop.y <= arr.get(i).y) {
//				ans += (arr.get(i).x - currenttop.x) * currenttop.y;
//				currenttop = arr.get(i);
//				maxX = i;
//			}
//		}
//
//		//왼쪽에서 오른쪽으로
//		currenttop = arr.get(N-1);
//		for (int i = 0; i < N-maxX; i++) {
//			if(currenttop.y <= arr.get(N-i-1).y) {
//				ans += (currenttop.x - arr.get(N-i-1).x ) * currenttop.y;
//				currenttop = arr.get(N-i-1);
//			}
//		}
//		ans += currenttop.y;
//		System.out.println(ans);
//	}
//
//	static class top implements Comparable<top> {
//		int x;
//		int y;
//
//		public top(int x, int y) {
//			super();
//			this.x = x;
//			this.y = y;
//		}
//
//		@Override
//		public int compareTo(top o) {
//			// TODO Auto-generated method stub
//			return this.x - o.x;
//		}
//
//	}
//}
