package com.example.Assignments;

import java.util.*;

public class InfixToPostfix {
    private String postfix = "";
    private final Stack<Character> stack = new Stack<>();
    private final String OPERATORS = "+-*x/÷%^";

    private int priority(char op) {
        if (op == '+' || op == '-')
            return 1;
        else if (op == '*' || op == 'x' || op == '/' || op == '÷' || op == '%') {
            return 2;
        } else if (op == '^')
            return 3;
        return 0;
    }

    public static class BooleanQueryConverter {
        private static final Map<String, Integer> operatorPrecedence = new HashMap<>();
        static {
            operatorPrecedence.put("-", 3); // Difference operator (highest precedence)
            operatorPrecedence.put("AND", 2); // AND operator
            operatorPrecedence.put("OR", 1); // OR operator (lowest precedence)
        }

        public static List<String> infixToPostfix(String query) {
            List<String> output = new ArrayList<>();
            Deque<String> operatorStack = new ArrayDeque<>();

            String[] tokens = query.split("\\s+");

            for (String token : tokens) {
                if (isOperator(token)) {
                    while (!operatorStack.isEmpty() && isOperator(operatorStack.peek()) &&
                            operatorPrecedence.get(token) <= operatorPrecedence.get(operatorStack.peek())) {
                        output.add(operatorStack.pop());
                    }
                    operatorStack.push(token);
                } else if (token.equals("(")) {
                    operatorStack.push(token);
                } else if (token.equals(")")) {
                    while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                        output.add(operatorStack.pop());
                    }
                    operatorStack.pop(); // Pop the opening parenthesis
                } else {
                    output.add(token);
                }
            }

            while (!operatorStack.isEmpty()) {
                output.add(operatorStack.pop());
            }

            return output;
        }

        private static boolean isOperator(String token) {
            return operatorPrecedence.containsKey(token);
        }
    }

    public String conversion(String infix) {
        for (int i = 0; i < infix.length(); i++) {
            char current = infix.charAt(i);
            if (current == ' ')
                continue;
            if (Character.isDigit(current)) {
                if (i < infix.length() - 1 && Character.isDigit(infix.charAt(i + 1))) {
                    postfix += current;
                    continue;
                }
                postfix += current + " ";
            } else if (current == '(')
                stack.push(current);

            else if (OPERATORS.indexOf(current) > -1) {
                while (!stack.isEmpty() && priority(current) <= priority(stack.peek())) {
                    postfix += stack.pop() + " ";
                }
                stack.push(current);
            }

            else if (current == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix += stack.pop() + " ";
                }
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            postfix += stack.pop() + " ";
        }

        return postfix;
    }

    public double evaluate() {
        String[] arr = postfix.split(" ");
        Stack<Double> result = new Stack<>();
        for (String s : arr) {
            if (OPERATORS.contains(s)) {
                double x = result.pop();
                double y = result.pop();
                switch (s) {
                    case "+":
                        result.push(y + x);
                        break;
                    case "-":
                        result.push(y - x);
                        break;
                    case "*":
                    case "x":
                        result.push(y * x);
                        break;
                    case "/":
                    case "÷":
                        result.push(y / x);
                        break;
                    case "^":
                        result.push(Math.pow(y, x));
                        break;
                    case "%":
                        result.push(y % x);
                        break;
                }

            } else
                result.push((double) (Integer.parseInt(s)));
        }
        return result.pop();
    }

    public static void main(String[] args) {
        InfixToPostfix conv = new InfixToPostfix();
        System.out.println(conv.conversion("5+4-6*(8-9)/2"));
        System.out.println(conv.evaluate());
    }
}
