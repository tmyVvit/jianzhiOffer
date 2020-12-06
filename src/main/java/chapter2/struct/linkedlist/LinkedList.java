package chapter2.struct.linkedlist;

public class LinkedList {
    private ListNode head;

    public void addToTail(int value) {
        if (head == null) {
            head = new ListNode();
        }
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new ListNode(value);

    }

    public void removeNode(int value) {
        if (head == null) return ;
        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == value) {
                node.next = node.next.next;
                break;
            }
        }
    }


    class ListNode {
        int val;
        ListNode next;
        ListNode () { }
        ListNode(int value) {
            val = value;
            next = null;
        }
    }
}
