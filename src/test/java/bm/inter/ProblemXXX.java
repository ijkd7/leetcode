package bm.inter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProblemXXX {

    @Test
    void example1() {
        var list1 = new int[]{1, 2, 4};
        var list2 = new int[]{1, 3, 4};
        var answer = new int[]{1, 1, 2, 3, 4, 4};
        var resultNode = mergeTwoLists(createListNode(list1), createListNode(list2));
        Assertions.assertTrue(compare(answer, resultNode));
    }

    @Test
    void example2() {
        var list1 = new int[]{};
        var list2 = new int[]{0};
        var answer = new int[]{0};
        var resultNode = mergeTwoLists(createListNode(list1), createListNode(list2));
        Assertions.assertTrue(compare(answer, resultNode));
    }

    @Test
    void example3() {
        var list1 = new int[]{};
        var list2 = new int[]{};
        var answer = new int[]{};
        var resultNode = mergeTwoLists(createListNode(list1), createListNode(list2));
        Assertions.assertTrue(compare(answer, resultNode));
    }

    private boolean compare(int[] answer, ListNode node) {
        for (int i : answer) {
            if (answer[i] == node.val) {
                node = node.next;
            } else {
                return false;
            }
        }
        return true;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while(list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else if (list2 != null) {
            current.next = list2;
        }

        return dummy.next;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode tail = head;
        while (true) {
            if (list1 == null && list2 == null) {
                break;
            } else if (list1 == null) {
                tail.val = list2.val;
                list2 = list2.next;
            } else if (list2 == null) {
                tail.val = list1.val;
                list1 = list1.next;
            } else if (list1.val <= list2.val) {
                tail.val = list1.val;
                list1 = list1.next;
            } else {
                tail.val = list2.val;
                list2 = list2.next;
            }
            if (!(list1 == null && list2 == null)) {
                tail.next = new ListNode();
                tail = tail.next;
            }
        }
        return head;
    }

    public class ListNode {
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

}
