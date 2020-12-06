package chapter2.struct.linkedlist;

import java.util.Stack;

public class LinkedList {
    private ListNode head = new ListNode();

    public LinkedList addToTail(int value) {
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new ListNode(value);
        return this;
    }

    public LinkedList removeNode(int value) {
        if (head == null) return this;
        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == value) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return this;
    }

    public String printList() {
        ListNode node = head;
        StringBuilder sb = new StringBuilder();
        while (node.next != null) {
            sb.append(node.next.val).append(" --> ");
            node = node.next;
        }
        sb.append("null \n");
        return sb.toString();
    }

    public String printReverse() {
        Stack<Integer> stack = new Stack<Integer>();
        ListNode node = head;
        while (node.next != null) {
            stack.push(node.next.val);
            node = node.next;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            if (sb.length() > 0) {
                sb.append(" --> ");
            }
            sb.append(stack.pop());
        }
        return sb.toString();
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode () { }
        ListNode(int value) {
            val = value;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.addToTail(1).addToTail(2).addToTail(3);
        list.removeNode(2);
        System.out.println(list.printList());
        System.out.println(list.printReverse());
    }
}
