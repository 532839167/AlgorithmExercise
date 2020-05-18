package array;

import queue.ArrayQueue;
import queue.LoopQueue;
import stack.ArrayStack;

public class Main {

    public static void main(String[] args) {
        LoopQueue<Integer> q = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            q.enqueue(i);
            System.out.println(q);

            if (i % 3 == 2) {
                q.dequeue();
                System.out.println(q);
            }
        }
    }
}
