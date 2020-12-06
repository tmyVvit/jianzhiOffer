package chapter2.struct.stackandqueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

// 用两个队列实现栈
public class CStack<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;

    public CStack() {
        queue1 = new LinkedList<T>();
        queue2 = new LinkedList<T>();
    }

    public CStack<T> push(T value) {
        if (queue1.size() > 0) {
            queue1.offer(value);
        } else {
            queue2.offer(value);
        }
        return this;
    }

    public T pop() {
        Queue<T> q1 = queue1.size() > 0 ? queue1 : queue2;
        Queue<T> q2 = q1 == queue1 ? queue2 : queue1;
        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }
        return q1.poll();
    }

    public int size() {
        Queue<T> q1 = queue1.size() > 0 ? queue1 : queue2;
        return q1.size();
    }

    public void removeAllAndPrint() {
        while (size() > 0) {
            System.out.println(pop());
        }
    }

    public static void main(String[] args) {
        CStack<Integer> stack = new CStack<Integer>();
        stack.push(1).push(2).push(3);
        stack.removeAllAndPrint();
    }
}
