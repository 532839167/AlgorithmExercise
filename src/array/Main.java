package array;

public class Main {

    public static void main(String[] args) {
        Array<Integer> arr = new Array(20);
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);

        arr.add(1, 100);
        System.out.println(arr);

        arr.addLast(-1);
        System.out.println(arr);

        System.out.println("-----------------------");

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirtst();
        System.out.println(arr);
    }
}