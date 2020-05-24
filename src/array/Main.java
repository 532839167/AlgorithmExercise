package array;

import queue.ArrayQueue;
import queue.LinkedListQueue;
import queue.LoopQueue;
import stack.ArrayStack;
import linkedList.LinkedList;
import stack.LinkedListStack;


public class Main {

    public static void main(String[] args) {

        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }


    }
}
