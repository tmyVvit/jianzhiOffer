package chapter2.struct.stackandqueue;

import java.util.Stack;

// 面试题 9 用两个栈来实现队列
public class CQueue<T> {
    private Stack<T> in;
    private Stack<T> out;

    public CQueue() {
        in = new Stack<T>();
        out = new Stack<T>();
    }

    public void appendTail(T value) {
        in.push(value);
    }

    public T deleteHead() {
        if (out.empty()) {
            while (!in.empty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }
}
