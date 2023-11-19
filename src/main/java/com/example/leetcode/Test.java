package com.example.leetcode;

import java.util.*;

public class Test {
    private List<String> list = new ArrayList<>();
    public List<String> generatePar(int n) {
        recurse("", 0, 0, n);
        return list;
    }

    private boolean validPar(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char par = str.charAt(i);
            if (par == ')') {
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
            else
                stack.push(par);
        }
        return stack.isEmpty();
    }

    private void recurse(String str, int o, int c, int n) {
        if (o == n && c == n) {
            if (validPar(str))
                list.add(str);
            return;
        }

        if (c == n)
            recurse(str + '(', o + 1, c, n);
        else if (o == n)
            recurse(str + ')', o, c + 1, n);
        else {
            recurse((str + '('), o + 1, c, n);
            recurse((str + ')'), o, c + 1, n);
        }
    }

    public static void main(String[] args) {
        Map<String, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 6, 1, 7));
        map.put("foo", list);

        List<Integer> temp = map.get("foo");
        temp.add(-1);

        List<Integer> temp1 = map.get("foo");
        for (int i : temp1) {
            System.out.print(i + " ");
        }

        
    }

//    public static void move(int n, char src, char dst, char tmp, int count) {
//        if (n == 1) {
//            System.out.println("move " + n + " from " + src + " to " + dst + " ");
//        }
//        else {
//            move(n - 1, src, tmp, dst, count++);
//            System.out.println("move " + n + " from " + src + " to " + dst + " ");
//            move(n - 1, tmp, dst, src, count++);
//        }
//    }
}

