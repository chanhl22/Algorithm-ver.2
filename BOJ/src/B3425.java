//playtime = 03:18:11

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class B3425 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String quit = sc.nextLine();
            ArrayList<String> programing = new ArrayList<>();
            if (quit.equals("QUIT")) {
                break;
            } else {
                if (!quit.equals("END")) {
                    programing.add(quit);
                    while (true) {
                        String end = sc.nextLine();
                        if (end.equals("END")) {
                            break;
                        } else {
                            programing.add(end);
                        }
                    }
                }
                int n = sc.nextInt();
                long[] input = new long[n];
                for (int i = 0; i < n; i++) {
                    input[i] = sc.nextLong();
                    sc.nextLine();
                }
                sc.nextLine();
                for (int i = 0; i < n; i++) {
                    boolean ok = false;
                    Stack<Long> stack = new Stack<>();
                    stack.add(input[i]);
                    for (int j = 0; j < programing.size(); j++) {
                        if (programing.get(j).equals("POP")) {
                            if (stack.isEmpty()) {
                                System.out.println("ERROR");
                                ok = true;
                                break;
                            } else {
                                stack.pop();
                            }
                        } else if (programing.get(j).equals("INV")) {
                            if (stack.isEmpty()) {
                                System.out.println("ERROR");
                                ok = true;
                                break;
                            } else {
                                long temp = stack.pop();
                                if (Math.abs(temp) > 1000000000) {
                                    System.out.println("ERROR");
                                    ok = true;
                                    break;
                                }
                                temp *= -1;
                                stack.push(temp);
                            }
                        } else if (programing.get(j).equals("DUP")) {
                            if (stack.isEmpty()) {
                                System.out.println("ERROR");
                                ok = true;
                                break;
                            } else {
                                long temp = stack.peek();
                                stack.push(temp);
                            }
                        } else if (programing.get(j).equals("SWP")) {
                            if (stack.isEmpty() || stack.size() == 1) {
                                System.out.println("ERROR");
                                ok = true;
                                break;
                            } else {
                                long temp1 = stack.pop();
                                long temp2 = stack.pop();
                                stack.push(temp1);
                                stack.push(temp2);
                            }
                        } else if (programing.get(j).equals("ADD")) {
                            if (stack.isEmpty() || stack.size() == 1) {
                                System.out.println("ERROR");
                                ok = true;
                                break;
                            } else {
                                long temp1 = stack.pop();
                                long temp2 = stack.pop();
                                if (Math.abs(temp1 + temp2) > 1000000000) {
                                    System.out.println("ERROR");
                                    ok = true;
                                    break;
                                }
                                stack.push(temp1 + temp2);
                            }
                        } else if (programing.get(j).equals("SUB")) {
                            if (stack.isEmpty() || stack.size() == 1) {
                                System.out.println("ERROR");
                                ok = true;
                                break;
                            } else {
                                long temp1 = stack.pop();
                                long temp2 = stack.pop();
                                if (Math.abs(temp2 - temp1) > 1000000000) {
                                    System.out.println("ERROR");
                                    ok = true;
                                    break;
                                }
                                stack.push(temp2 - temp1);
                            }
                        } else if (programing.get(j).equals("MUL")) {
                            if (stack.isEmpty() || stack.size() == 1) {
                                System.out.println("ERROR");
                                ok = true;
                                break;
                            } else {
                                long temp1 = stack.pop();
                                long temp2 = stack.pop();
                                if (Math.abs(temp1 * temp2) > 1000000000) {
                                    System.out.println("ERROR");
                                    ok = true;
                                    break;
                                }
                                stack.push(temp2 * temp1);
                            }
                        } else if (programing.get(j).equals("DIV")) {
                            if (stack.isEmpty() || stack.size() == 1) {
                                System.out.println("ERROR");
                                ok = true;
                                break;
                            } else {
                                long temp1 = stack.pop();
                                long temp2 = stack.pop();
                                if (temp1 == 0) {
                                    System.out.println("ERROR");
                                    ok = true;
                                    break;
                                }
                                int check = 0;
                                if (temp1 < 0 && temp2 < 0) {
                                    check = 3;
                                } else if (temp1 < 0) {
                                    temp1 *= -1;
                                    check = 1;
                                } else if (temp2 < 0) {
                                    temp2 *= -1;
                                    check = 2;
                                }
                                if (check == 1 || check == 2) {
                                    stack.push((temp2 / temp1) * -1);
                                } else {
                                    stack.push(temp2 / temp1);
                                }
                            }
                        } else if (programing.get(j).equals("MOD")) {
                            if (stack.isEmpty() || stack.size() == 1) {
                                System.out.println("ERROR");
                                ok = true;
                                break;
                            } else {
                                long temp1 = stack.pop();
                                long temp2 = stack.pop();
                                if (temp1 == 0) {
                                    System.out.println("ERROR");
                                    ok = true;
                                    break;
                                }
                                int check = 0;
                                if (temp1 < 0 && temp2 < 0) {
                                    temp1 *= -1;
                                    temp2 *= -1;
                                    check = 1;
                                }
                                if (temp2 < 0) {
                                    temp2 *= -1;
                                    check = 1;
                                } else if (temp1 < 0) {
                                    temp1 *= -1;
                                }
                                if (check == 1) {
                                    stack.push((temp2 % temp1) * -1);
                                } else {
                                    stack.push(temp2 % temp1);
                                }
                            }
                        } else {
                            String[] num = programing.get(j).split(" ");
                            stack.push(Long.parseLong(num[1]));
                        }
                    }
                    if (ok) continue;
                    if (stack.size() == 1) {
                        System.out.println(stack.pop());
                    } else {
                        System.out.println("ERROR");
                    }
                }
                System.out.println();
            }
        }
    }
}