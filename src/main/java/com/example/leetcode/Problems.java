package com.example.leetcode;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Problems {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 5};

        System.out.println(isPossible(arr));
    }

    public static boolean isPossible(int[] nums) {
        boolean[] visited = new boolean[nums.length];

        int count = 0;

        while (count != visited.length) {
            int l = getFirstNotVisited(visited);
            visited[l] = true;
            count++;
            for (int r = l + 1; r < nums.length; r++) {
                if (visited[r] || nums[r] == nums[l]) {
                    r++;
                    continue;
                }
                if (nums[r] - nums[l] == 1) {
                    visited[r] = true;
                    if (visited.length - count + 1 >= 3)
                        count++;
                    else
                        break;
                    l = r;
                } else if (nums[r] - nums[l] > 1)
                    return false;
            }
            if (visited.length - count == 2 || visited.length - count == 1)
                return false;
        }
        return true;
    }

    private static int getFirstNotVisited (boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (!arr[i])
                return i;
        }
        return -1;
    }

    // the idea is to compare the indexOf in each word
    public static List<String> pattern2(String[] words, String pattern) {
        if (pattern.length() == 1)
            return new ArrayList<>(Arrays.asList(words));

        List<String> list = new ArrayList<>(words.length);

        for (String word : words) {
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (word.indexOf(word.charAt(i)) != pattern.indexOf(pattern.charAt(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                list.add(word);
        }
        return list;
    }

    // 46 / 47 test cases passed:
    public static List<String> pattern(String[] words, String pattern) {
        if (pattern.length() == 1)
            return new ArrayList<>(Arrays.asList(words));

        List<String> list = new ArrayList<>(words.length);

        for (String word : words) {
            HashMap<Character, Integer> wordMap = new HashMap<>();
            HashMap<Character, Integer> patternMap = new HashMap<>();
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                char ch1 = pattern.charAt(i);
                wordMap.put(ch, Math.abs(ch - ch1));
                patternMap.put(ch1, Math.abs(ch - ch1));
            }

            for (int i = 0; i < word.length(); i++) {
                if (wordMap.containsKey(word.charAt(i))) {
                    if (!wordMap.get(word.charAt(i)).equals(patternMap.get(pattern.charAt(i)))) {
                        flag = false;
                    }
                }
                if (patternMap.containsKey(pattern.charAt(i))) {
                    if (!wordMap.get(word.charAt(i)).equals(patternMap.get(pattern.charAt(i)))) {
                        flag = false;
                    }
                }
            }
            if (flag)
                list.add(word);
        }
        return list;
    }

    public static ListNode reverse(ListNode head) {
//
//        ListNode last = head;
//        ListNode current = head.next;
//
//        while (current != null) {
//            ListNode front = current.next;
//
//            current.next = last;
//            last = current;
//            current = front;
//        }
//        head.next = null;
//        head = last;
//        return head;
        ListNode back = head;
        ListNode current = head.next;

        while (current != null) {
            ListNode front = current.next;

            current.next = back;
            back = current;
            current = front;
        }

        head.next = null;
        head = back;
        return head;
    }

    public static List<String> wordSubSet(String[] words1, String[] words2) {
        int[] freq = new int[26];
        StringBuilder concat = new StringBuilder();
        List<String> list = new ArrayList<>(words1.length);
        for (String word : words2) {
            int[] temp = new int[26];
            for (char c : word.toCharArray())
                temp[c - 'a']++;

            for (int i = 0; i < temp.length; i++) {
                freq[i] = Math.max(freq[i], temp[i]);
            }
            concat.append(word);
        }

        char[] sub = concat.toString().toCharArray();

        for (String word : words1) {
            int[] counter = new int[26];
            boolean flag = true;
            char[] arr = word.toCharArray();
            for (char c : arr) {
                counter[c - 'a']++;
            }

            for (char c : sub) {
                if (counter[c - 'a'] < freq[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                list.add(word);
        }
        return list;
    }

    public static int kthSmallestInMatrix(int[][] matrix, int k) {
        int len = matrix.length;
        int low = matrix[0][0];
        int high = matrix[len - 1][len - 1];

        while (low < high) {
            int mid = (low + high) / 2;
            int count = countLess(matrix, mid);

            if (count < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public static int countLess(int[][] matrix, int target) {
        int len = matrix.length;
        int i = 0;
        int j = len - 1;
        int count = 0;

        while (j >= 0 && i < len) {
            int cell = matrix[i][j];

            if (cell < target)
                j--;
            else {
                count += (j + 1);
                i++;
            }
        }
        return count;
    }


    private static int count;
    private static HashMap<Integer, Integer> memo = new HashMap<>();
    public static int combinationSum4(int[] nums, int target) {
        if (target == 0)
            return 1;
        if (target < 0)
            return 0;

        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            int r = combinationSum4(nums, key);
            if (memo.containsKey(key)) {
                count += memo.get(key);
                continue;
            }
            if (r == 0) {
                count++;
                memo.put(key, count);
            }
            else {
                memo.put(key, 0);
            }
        }
        return count;
    }

    public static int indexOfFirstNonRepeated(String str) {
        Queue<Character> queue = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                int count = map.get(c);
                count++;
                map.put(c, count);
            }
            else
                map.put(c, 1);
            queue.add(c);
        }

        int index = 0;
        while (!queue.isEmpty()) {
            if (map.get(queue.remove()) == 1)
                return index;
            index++;
        }
        return -1;
    }

    public static boolean find132Pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            if (stack.size() > 2) {
                int n3 = stack.pop();
                if (n3 > stack.peek())
                    if (nums[i] < n3 && nums[i] > stack.peek())
                        return true;
                    else
                        continue;
                stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static boolean searchIn2DMatrix2(int[][] matrix, int target) {
        int i = 0;
        int j = matrix[0].length - 1;

        while (i != matrix.length && j >= 0) {
            int cell = matrix[i][j];
            if (cell == target)
                return true;
            else if (cell < target)
                i++;
            else
                j--;
        }
        return false;
    }

    public static int searchInCircularSortedArray(int[] nums, int target) {
        int pivot = findPivot(nums, 0, nums.length - 1);


        System.out.println(pivot);
        if (nums[pivot] == target)
            return pivot;
        else if (target > nums[pivot] && target < nums[nums.length])
            return binarySearch(nums, 0, pivot - 1, target);
        else
            return binarySearch(nums, pivot + 1, nums.length, target);
    }

    public static int findPivot(int[] nums, int low, int high) {
        if (nums[low] < nums[high])
            return 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int next = (mid + 1) % nums.length;
            int prev = (mid + nums.length - 1) % nums.length;
            if (nums[mid] < nums[prev] && nums[mid] < nums[next])
                return mid;

            if (nums[mid] > nums[low])
                low = mid + 1;

            if (nums[mid] < nums[high])
                high = mid - 1;
        }

        return high;
    }

    public static int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
}
