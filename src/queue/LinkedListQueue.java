package queue;

import linkedList.LinkedList;
import org.w3c.dom.Node;

public class LinkedListQueue<E> implements Queue{

    private class Node {
        public E e;
        public Node next;

        public Node (E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(Object o) {
        if (tail == null) {
            // Queue is empty
            tail = new Node((E) o);
            head = tail;
        } else {
            tail.next = new Node((E) o);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue an empty queue");
        }

        Node retNode = head;
        head = head.next;
        retNode.next = null;

        if (head == null) {
            tail = null;
        }

        size --;

        return retNode.e;
    }

    @Override
    public Object getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while (cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
