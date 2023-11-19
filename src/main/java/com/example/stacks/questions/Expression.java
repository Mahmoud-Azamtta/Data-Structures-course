package com.example.stacks.questions;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

    private final List<Character> leftBracket = Arrays.asList('(', '<', '{', '[');
    private final List<Character> rightBracket = Arrays.asList(')', '>', '}', ']');

    public boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (isLeftBracket(c))
                stack.push(c);
            if (isRightBracket(c)) {
                if (stack.empty())
                    return false;
                char top = stack.pop();
                if (!isMatching(top, c))
                    return false;
            }
        }

        return stack.empty();
    }

    private boolean isLeftBracket(char ch) {
        return leftBracket.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return rightBracket.contains(ch);
    }

    private boolean isMatching(char left, char right) {
        return leftBracket.indexOf(left) == rightBracket.indexOf(right);
    }
}
