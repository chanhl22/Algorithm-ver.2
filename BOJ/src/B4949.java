import java.util.Scanner;
import java.util.Stack;

public class B4949 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.nextLine();
            if (str.equals(".")) {
                break;
            }
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    stack.push('(');
                } else if (str.charAt(i) == '[') {
                    stack.push('[');
                } else if (str.charAt(i) == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(')');
                    }
                } else if (str.charAt(i) == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(']');
                    }
                }
            }
            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}

//Another Solution
//import java.util.Scanner;
//import java.util.Stack;
//
//public class Main {
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		String s;
//		while(true) {
//			s = in.nextLine();
//			if(s.equals(".")) {	// 종료 조건문
//				break;
//			}
//			System.out.println(solve(s));
//		}
//	}
//
//	public static String solve(String s) {
//		Stack<Character> stack = new Stack<>();
//		for(int i = 0; i < s.length(); i++) {
//			char c = s.charAt(i);	// i 번째 문자
//			// 여는 괄호일 경우 스택에 push
//			if(c == '(' || c == '[') {
//				stack.push(c);
//			}
//			// 닫는 소괄호 일 경우
//			else if(c == ')') {
//				// 스택이 비어있거나 pop할 원소가 소괄호랑 매칭이 안되는 경우
//				if(stack.empty() || stack.peek() != '(') {
//					return "no";
//				}
//				else {
//					stack.pop();
//				}
//			}
//			else if(c == ']') {
//				// 스택이 비어있거나 pop할 원소가 대괄호랑 매칭이 안되는 경우
//				if(stack.empty() || stack.peek() != '[') {
//					return "no";
//				}
//				else {
//					stack.pop();
//				}
//			}
//			// 그 외의 경우에는 불필요한 문자들이기에 skip한다.
//		}
//		if(stack.empty()) {
//			return "yes";
//		}
//		else {
//			return "no";
//		}
//	}
//}

//Another Solution
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        while (true) {
//            String a = sc.nextLine();
//            if (a.equals("."))
//                break;
//            // .은 종료
//            String[] input = a.split(""); // 입력값들 쪼개서 넣기
//            Stack<String> stack = new Stack<>();
//            for (String str : input) {
//                if (str.equals("(") || str.equals("["))
//                    stack.push(str); // 열린 괄호는 그냥 넣기
//                // 닫히는 괄호는 스택이 비어있지 않고 바로 위 값이 열리는 짝 괄호면 pop
//                else if (str.equals(")") && !stack.isEmpty() && stack.peek().equals("("))
//                    stack.pop();
//                else if (str.equals("]") && !stack.isEmpty() && stack.peek().equals("["))
//                    stack.pop();
//                // 닫히는 괄호인데 해당 없으면 삽입
//                else if (str.equals(")") || str.equals("]"))
//                    stack.push(str);
//            }
//            if (stack.empty()) // 스택이 비었으면
//                System.out.println("yes");
//            else // 비지 않았으면
//                System.out.println("no");
//        }
//    }
//}

