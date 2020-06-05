package array;

import queue.ArrayQueue;
import queue.LinkedListQueue;
import queue.LoopQueue;
import stack.ArrayStack;
import linkedList.LinkedList;
import stack.LinkedListStack;
import BST.BST;


public class Main {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<Integer>();
        int[] nums = {5, 3, 6, 8, 4, 2};

        for (int n: nums) {
            bst.add(n);
        }

        bst.preOrder();
        System.out.println();

        System.out.println(bst);

    }
}
