package com.example.leetcode;

import jdk.swing.interop.SwingInterOpUtils;

import javax.sound.sampled.Line;
import java.nio.file.NotLinkException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class DSProblems {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 =  n1.next = new ListNode(2);
        ListNode n3 = n2.next = new ListNode(3);
        ListNode n4 = n3.next = new ListNode(4);
        n4.next = null;


        ListNode m1 = new ListNode(1);
        ListNode m2 = m1.next = new ListNode(2);
        ListNode m3 = m2.next = new ListNode(3);
        ListNode m4 = m3.next = new ListNode(4);
        ListNode m5 = m4.next = new ListNode(5);
        ListNode m6 = m5.next = new ListNode(6);
        ListNode m7 = m6.next = new ListNode(7);
        ListNode m8 = m7.next = new ListNode(8);
        m8.next = null;

        // ListNode sum = addTwoNumbers(n1, m1);

        // ListNode merged = mergeTwoSortedLists(n1, m1);

        //ListNode merged = mergeUsingRecursion(n1, m2);

        //ListNode head = reverseTwoNodes(m1, 2);

        //ListNode head = reverseBetween(m1, 2, 4);

        //ListNode head = reverse(m1);

        // System.out.println(isPalindrome(n1));
        // System.out.println(isPalindrome(m1));

        //ListNode head =  removeNthNode(m1, 2);

        //ListNode head = removeTheMiddleNode(n1);

        //ListNode head = partitionList(m1, 3);

        //ListNode head = deleteDuplicates(m1);

        //System.out.println(maxSum(n1));

        //ListNode head = reorderList(n1);

        //ListNode head = reorderList(m1);

        //ListNode head = swapPairs(m1);

        //ListNode head = removeElements(m1, 2);

        //deleteNodeByValue(m4);

//        while (m1 != null) {
//            System.out.print(m1.val + " ");
//            m1 = m1.next;
//        }
/////////////////////////////////////////////////////
        //ListNode head = reverseKGroup(m1, 2);
/////////////////////////////////////////////////////

        //ListNode head = oddEvenList(m1);

        //ListNode head = swapNodes(m1, 1);

        //ListNode head = recursiveReverse(m1);

        //System.out.println(recursiveMid(m1));

        reorder(m1);
        ListNode head = m1;
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val + l2.val;
        int rem = sum % 10;
        int div = sum / 10;
        ListNode current = new ListNode(rem);
        ListNode summation = current;

        ListNode node1 = l1.next;
        ListNode node2 = l2.next;

        while (node1 != null || node2 != null) {
            if (node1 == null) {
                sum = node2.val + div;
                node2 = node2.next;
            } else if (node2 == null) {
                sum = node1.val + div;
                node1 = node1.next;
            } else {
                sum = node1.val + node2.val + div;
                node1 = node1.next;
                node2 = node2.next;
            }
            rem = sum % 10;
            div = sum / 10;
            summation.next = new ListNode(rem);
            summation = summation.next;
        }
        if (div != 0)
            summation = summation.next = new ListNode(div);

        summation.next = null;

        return current;

        // another solution:
        /*
         public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;

        //current init
        ListNode resNode = new ListNode();
        ListNode copyNode = resNode;

        //start iteration
        while(l1!=null || l2!=null || sum!= 0)
        {
            if(l1!=null)
            {
                sum += l1.val;
                l1 = l1.next;
            }

            if(l2!=null)
            {
                sum += l2.val;
                l2 = l2.next;
            }

            ListNode newNode = new ListNode();
            newNode.val = sum%10;
            copyNode.next = newNode;
            copyNode = newNode;

            sum/=10;   //will always be 0 or 1
        }

        return resNode.next;
        }
         */
    }

    public static int[] mergeTwoStoredArrays(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i != arr1.length && j != arr2.length) {
            if (arr1[i] < arr2[j]) {
                ans[k] = arr1[i++];
            } else {
                ans[k] = arr2[j++];
            }
            k++;
        }

        if (i == arr1.length) {
            while (k != ans.length) {
                ans[k++] = arr2[j++];
            }
        }
        else {
            while (k != ans.length) {
                ans[k++] = arr1[i++];
            }
        }

        return ans;
    }

    public static ListNode mergeTwoSortedLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode head = new ListNode();
        ListNode tail;

        if (list1.val < list2.val) {
            head.val = list1.val;
            list1 = list1.next;
        }
        else {
            head.val = list2.val;
            list2 = list2.next;
        }

        tail = head;

        while (list1 != null && list2 != null) {
            ListNode current = new ListNode();
            if (list1.val <  list2.val) {
                current.val = list1.val;
                list1 = list1.next;
            }
            else {
                current.val = list2.val;
                list2 = list2.next;
            }
            tail.next = current;
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        }
        else tail.next = list2;

        return head;
    }

    public static ListNode mergeUsingRecursion(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        if (list1.val < list2.val) {
            return new ListNode(list1.val, mergeUsingRecursion(list1.next, list2));
        }
        else {
            return new ListNode(list2.val, mergeUsingRecursion(list1, list2.next));
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right)
            return head;

        // the dummy node solve the problem when the list has only two nodes
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // the for loop down is to get the node at the given left and the one before it
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode current = prev.next;
        // to swap the current node and the one in front of it
        for (int i = 0; i < (right - left); i++) {
            ListNode front = current.next; // keeping track of the node in front of current;

            current.next = front.next;
            front.next = prev.next;
            prev.next = front;
        }
        return dummy.next;
    }

    public static ListNode reverseTwoNodes(ListNode head, int at) {
        ListNode prev = head;

        for (int i = 0; i < at - 1; i++) {
            prev = prev.next;
        }

        ListNode current = prev.next;
        ListNode front = current.next;

        current.next = front.next;
        front.next = prev.next;
        prev.next = front;

        return head;
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

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast == null) {
            ListNode even = head;
            while (even.next != slow) {
                even = even.next;
            }
            slow = even;
        }

        slow.next = reverse(slow.next);

        slow = slow.next;
        while (slow != null) {
            if (slow.val != head.val)
                return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }

    public static ListNode removeNthNode(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        ListNode left = head;
        ListNode right = head;

        for (int i = 0; i < n; i++) {
            if (right == null)
                break;
            right = right.next;
        }

        // if right == null then left has to be equal to the head
        if (right != null) {
            while (right != null) {
                left = left.next;
                right = right.next;
            }
        }

        // and if left is equal to the head there is no point of getting the previous node
        // left.next is simply returned
        if (left == head) {
            return left.next;
        }

        ListNode prev = head;

        while (prev.next != left) {
            prev = prev.next;
        }

        prev.next = left.next;
        left.next = null;

        return head;
    }

    public static ListNode removeTheMiddleNode(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head; // slow will point to the mid

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = head;
        while (prev.next != slow)
            prev = prev.next;

        prev.next = slow.next;
        slow.next = null;
        return head;
    }

    public static ListNode partitionList(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode right = new ListNode(0);

        ListNode less = left;
        ListNode greater = right;

        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            }
            else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        less.next = right.next;
        greater.next = null;
        return left.next;
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode deleted = dummy;

        dummy.next = new ListNode(head.val);
        dummy = dummy.next;
        head = head.next;
        while (head != null) {
            if (dummy.val != head.val) {
                dummy.next = new ListNode(head.val);
                dummy = dummy.next;
            }
            head = head.next;
        }

        return deleted.next;
    }

    public static int maxSum(ListNode head) {
        ListNode current = head;
        int max = 0;
        Stack<Integer> stack = new Stack<>();

        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }

        while (head != null) {
            int sum = stack.pop() + head.val;
            if (sum > max)
                max = sum;
            head = head.next;
        }

        return max;
    }

    public static ListNode reorderList(ListNode head) {
        if (head.next == null || head.next.next == null)
            return null;
        ListNode mid = cutInHalf(head); // current we're cutting the list in half

        ListNode back = mid;
        ListNode current = mid.next;
        while (current != null) { // then, reversing the second half
            ListNode front = current.next;
            current.next = back;
            back = current;
            current = front;
        }
        mid.next = null;
        mid = back;

        System.out.println();
        ListNode reordered = head;
        while (reordered != null) {
            ListNode temp = reordered.next;
            ListNode temp1 = mid.next;

            reordered.next = mid;
            mid.next = temp;

            if (mid.next == null) // in case of odd number of elements after assigning mid.next = temp in
                mid.next = temp1; // the last iteration temp will be null, but mid still has a value
            // so, this value is assigned to mid.next
            reordered = temp;
            mid = temp1;
        }

        return head;
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode node = new ListNode();
        node.next = head;
        ListNode prev = node;

        ListNode current = prev.next;

        while (current != null && current.next != null) {
            ListNode front = current.next;
            ListNode temp = front.next;
            front.next = current;
            prev.next = front;
            current.next = temp;

            prev = current;
            current = temp;
        }

        return node.next;
    }

    public static ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            ListNode front = current.next;

            if (current.val == val) {
                if (front == null) {
                    prev.next = null;
                } else {
                    prev.next = front;
                    current.next = null;
                }
                current = front;
            } else {
                prev = current;
                current = current.next;
            }
        }
        return dummy.next;
    }

    public static void deleteNodeByValue(ListNode node) {
        ListNode prev = node;
        while (node.next != null) {
            prev = node;
            node.val = node.next.val;
            node = node.next;
        }
        prev.next = null;
    }

    public static ListNode cutInHalf(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        return slow;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
    public static ListNode cutAndReverse(ListNode first, ListNode last) {
        ListNode prev = first;
        while (first != last) {
            first = first.next;
        }
        first.next = null;

        ListNode back = prev;
        ListNode current = back.next;

        while (current != null) {
            ListNode temp = current.next;

            current.next = back;
            back = current;
            current = temp;
        }

        prev.next = null;
        return back;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode front = head;
        ListNode prev = head;

        int count = 0;

        while (front != null) {
            if (count == k - 1) {
                ListNode temp = front.next;
                prev = cutAndReverse(prev, front);
                front = temp;
                prev.next = temp;
                count = 0;
            }
            front = front.next;
            count++;
        }

        return dummy.next;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////

    public static ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        if (head.next.next == null)
            return head;

        ListNode prev = head;
        ListNode even = head.next;
        ListNode front = even.next;
        ListNode last = head;

        while (last.next != null)
            last = last.next;

        ListNode end = last;

        while (prev != end && prev.next != end) {
            prev.next = front;
            last.next = even;
            last = last.next;
            last.next = null;

            prev = front;
            even = front.next;
            front = even.next;
        }

        if (prev.next == end) {
            prev.next = front;
            last.next = even;
            last = last.next;
            last.next = null;
        }

        return head;
    }


    // another solution:
    public static ListNode oddEvenList2(ListNode head) {
        if(head == null || head.next == null || head.next.next == null)
            return head;

        ListNode firstEven = head.next;
        ListNode odd = head, even = head.next;

        while(even != null && even.next != null)
        {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }

        odd.next = firstEven;
        return head;
    }

    public static ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode left = head;
        for (int i = 0; i < k - 1; i++) {
            left = left.next;
        }

        ListNode count = left;
        ListNode right = head;

        while (count != null) {
            right = right.next;
            count = count.next;
        }
        int temp = right.val;
        right.val = left.val;
        left.val = temp;

        return dummy.next;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();

        ListNode curr = headA;
        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }

        curr = headB;
        while (curr != null) {
            if (set.contains(curr))
                return curr;
            curr = curr.next;
        }

        return null;
    }

    public static int binaryToDecimal(ListNode head) {
        if (head == null)
            return 0;

        int binary = 0;
        int base = 0;
        ListNode iterate = head.next;
        while (iterate != null) {
            iterate = iterate.next;
            base++;
        }

        while (head != null) {
            binary += head.val * Math.pow(2, base--);
            head = head.next;
        }
        return binary;
    }

    public static ListNode recursiveReverse(ListNode head) {
        if (head == null)
            return head;
        if (head.next == null)
            return head;

        ListNode revered = recursiveReverse(head.next);
        head.next.next = head;
        head.next = null;

        return revered;
    }

    public static int recursiveMid(ListNode head) {
        return recurse(head, head);
    }

    public static int recurse(ListNode fast, ListNode slow) {
        if (fast == null || fast.next == null) {
            return slow.val;
        }

        return recurse(fast.next.next, slow.next);
    }

    public static void reorder(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }

        curr = head;
        ListNode front = head.next;
        int n = stack.size();
        while (stack.size() > n / 2) {
            curr.next = stack.pop();
            curr.next.next = front;
            curr = front;
            front = curr.next;
        }
        curr.next = null;
    }
}


