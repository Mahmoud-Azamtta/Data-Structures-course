package com.example.lab;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("202011604", 10);
        map.put("202045324", 9);
        map.put("202084732", 12);
        map.put("202147530", 15);
        map.put("201947347", 14);

        String max = null;
        for (String str : map.keySet()) {
            if (max == null)
                max = str;
            else {
                if (map.get(str) >= map.get(max))
                    max = str;
            }
        }

        System.out.println(max + "\t" + map.get(max));
    }

    public static void leastAtLeft(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int elm = list.get(i);
            int min = Integer.MAX_VALUE;
            if (i == 0) {
                System.out.println(elm + "\t" + elm);
                continue;
            }

            for (int j = i - 1; j >= 0; j--) {
                min = Math.min(min, list.get(j));
            }

            System.out.println(elm + "\t" + min);
        }
    }

    public static void union(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        ArrayList<Integer> union = new ArrayList<>(l1.size() + l2.size());

        for (int integer : l1) {
            if (!union.contains(integer))
                union.add(integer);
        }

        for (int i : l2) {
            if (!union.contains(i))
                union.add(i);
        }

        for (int i : union)
            System.out.print(i + " ");
    }

    public static void largestInRightSide(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            int elm = list.get(i);
            int max = Integer.MIN_VALUE;
            if (i == list.size() - 1) {
                System.out.println(elm + "  " + elm);
                break;
            }

            for (int j = i + 1; j < list.size(); j++) {
                max = Math.max(max, list.get(j));
            }
            System.out.println(elm + "  " + max);
        }
    }

    public static void rotate(NewArrayList list, int k) {
        if (list.isEmpty())
            return;
        if (k % list.getSize() == 0)
            return;
        NewArrayList rotated = new NewArrayList(list.getSize());

        k = k % list.getSize();
        for (int i = k; i < list.getSize(); i++) {
            rotated.add(list.get(i));
        }

        for (int i = 0; i < k; i++) {
            rotated.add(list.get(i));
        }
        list.setArr(rotated.getArr());
    }

    public static boolean isPal(LinkedList<Integer> list) {
        LinkedList<Integer> reversed = new LinkedList<>();

        for (int i = 0; i < list.size(); i++) {
            reversed.addFirst(list.get(i));
        }

        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).equals(reversed.get(i)))
                return false;
        }
        return true;
    }

    public static boolean isSubList(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        ArrayList<Integer> greater;
        ArrayList<Integer> less;
        if (l1.size() > l2.size()) {
            greater = l1;
            less = l2;
        }
        else {
            greater = l2;
            less = l1;
        }

        for (Integer x : less) {
            if (!greater.contains(x))
                return false;
        }
        return true;
    }

    public static void swapIndices(ArrayList<Integer> list, int x, int y) {
        int temp = list.get(x);
        list.set(x, list.get(y));
        list.set(y, temp);
    }

    public static void reverse(ArrayList<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            int temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }

    public static boolean isPalindrome(ArrayList<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            if (!list.get(left).equals(list.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}