package fr.istic.vv;

import java.util.Stack;

public final class StringUtils{
    static final Stack stack = new Stack();

    public static void clearStack() {
        stack.clear();
    }

    public static boolean isBalanced(String testedString) {

        if (testedString.length() == 0) {
            if (stack.empty()) {
                return true;
            } else {
                return false;
            }

        } else {

            if (testedString.charAt(0) != '[' && testedString.charAt(0) != '('
                    && testedString.charAt(0) != '{') {

                switch (testedString.substring(0, 1)) {
                    case "]":
                        if (stack.peek().toString().charAt(0) == '[') {
                            stack.pop();
                            return isBalanced(testedString.substring(1));
                        } else {
                            return false;
                        }
                    case "}":
                        if (stack.peek().toString().charAt(0) == '{') {
                            stack.pop();
                            return isBalanced(testedString.substring(1));
                        } else {
                            return false;
                        }
                    case ")":
                        if (stack.peek().toString().charAt(0) == '(') {
                            stack.pop();
                            return isBalanced(testedString.substring(1));
                        } else {
                            return false;
                        }
                    default:
                        return false;
                }

            } else {

                stack.add(testedString.charAt(0));
                return isBalanced(testedString.substring(1));
            }

        }
    }
}
