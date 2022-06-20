import java.util.Stack;
import java.util.Scanner;
//Проверить, правильно ли расставлены скобки в данном коде.
class Staples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            System.out.println(isBalanced(s));
        }

    public static String isBalanced(String str) {

        Stack<CharinString> stack = new Stack<>();
        CharinString g = new CharinString('l',8);
        char c;
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            count++;

            if (c == '(' || c == '{' || c == '[') {
                stack.push( new CharinString(c, i));
            }

            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return String.valueOf(++i);
                }
                CharinString top = stack.peek();
                if ((c == ')' && top.symbol == '(') ||
                    (c == '}' && top.symbol == '{') ||
                    (c == ']' && top.symbol == '[')) {
                    stack.pop();
                } else {
                    return String.valueOf(++i);
                }
            }
        }

        if (!stack.isEmpty()) {
            return String.valueOf(stack.peek().index + 1);
        }
        return "Success";
    }
}

