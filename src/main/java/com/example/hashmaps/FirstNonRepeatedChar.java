package com.example.hashmaps; // and HashSets

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstNonRepeatedChar {
    public static void main(String[] args) {
        String str = "hello world";
        System.out.println(firstNonRepeated(str));
        System.out.println(firstRepeated(str));
    }

    public static char firstNonRepeated(String str) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        for (char c : chars) {
            /*if (map.containsKey(c)) {
            *     map.put(c, map.get(c) + 1);
            * }
            * else
            *     map.put(c, 1);
            */

            // the code above is the same as the one down
            int count = map.containsKey(c) ? map.get(c) : 0;
            map.put(c, count + 1);
        }
        System.out.println(map);
        for (char c : chars) {
            if (map.get(c) == 1)
                return c;
        }
        return Character.MIN_VALUE;
    }

    public static char firstRepeated(String str) {
        Set<Character> set = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (set.contains(c))
                return c;
            set.add(c);
        }
        return Character.MIN_VALUE;
    }
}
