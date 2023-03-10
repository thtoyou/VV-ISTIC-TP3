package fr.istic.vv;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public final class StringUtils {


    public static boolean isTheRightClosing(char ch, char shouldBeClosing) {
        return ((ch == ']' && shouldBeClosing == '[') || (ch == ')' & shouldBeClosing == '(') || (ch == '}' && shouldBeClosing == '{'));
    }

    public static boolean isBalanced(String testedString) {
        final Stack stack = new Stack();

        if (testedString.isEmpty()) {
            return true;
        }

        for (int i = 0; i < testedString.length(); i++) {
            char currentChar = testedString.charAt(i);
            if (!isLegal(currentChar)) {
                return false;
            }
            if (isOpen(currentChar)) {
                stack.push(currentChar);
            }
            if (isClosing(currentChar)) {
                if (stack.empty()) {
                    return false;
                }
                char topStack = (char) stack.pop();
                if (!isTheRightClosing(currentChar, topStack)) {
                    return false;
                }
            }
        }
        return stack.empty();


    }

    public static boolean isOpen(char ch) {
        Set<Character> opening = new HashSet<>();
        opening.addAll(Arrays.asList('{', '[', '('));
        return opening.contains(ch);
    }

    public static boolean isClosing(char ch) {
        Set<Character> closing = new HashSet<>();
        closing.addAll(Arrays.asList('}', ']', ')'));
        return closing.contains(ch);
    }

    public static boolean isLegal(char ch) {
        return (isClosing(ch) || isOpen(ch));
    }
}
