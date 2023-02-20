package bm.leetcode_tests.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Objects;

class Problem2 {

    @Test
    void example1() {
        var list1 = new int[]{2, 4, 3};
        var list2 = new int[]{5, 6, 4};
        var answer = new int[]{7, 0, 8};
        var resultNode = addTwoNumbers(createListNode(list1), createListNode(list2));
        for (int i = 0; i < answer.length; i++) {
            Assertions.assertEquals(answer[i], resultNode.val);
            resultNode = resultNode.next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return recursion(l1, l2, false);
    }

    public ListNode recursion (ListNode l1, ListNode l2, boolean overflow) {
        ListNode cur = new ListNode();
        cur.val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (overflow ? 1 : 0);
        if (cur.val > 9) {
            cur.val = cur.val - 10;
            overflow = true;
        } else {
            overflow = false;
        }
        if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || overflow) {
            cur.next = recursion(l1 == null ? null : l1.next, l2 == null ? null : l2.next, overflow);
        }
        return cur;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        boolean overflow = false;
        while (l1 != null || l2 != null) {
            if (current == null) {
                head = new ListNode();
                current = head;
            } else {
                current.next = new ListNode();
                current = current.next;
            }

            current.val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (overflow ? 1 : 0);
            if (current.val > 9) {
                current.val = current.val - 10;
                overflow = true;
            } else {
                overflow = false;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (overflow) {
            current.next = new ListNode(1);
        }

        return head;
    }

    private ListNode createListNode(int[] values) {
        var last = new ListNode();
        for (int i = values.length - 1; i >= 0; i--) {
            last.val = values[i];
            var newNode = new ListNode();
            newNode.next = last;
            if (i != 0) {
                last = newNode;
            }
        }
        return last;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
