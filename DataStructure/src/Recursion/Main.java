package Recursion;

/**
 * Created by shinsy1023 on 2016. 11. 7..
 */
public class Main {

    public static void main(String[] args) {
        RecursiveList list1 = new RecursiveList();
        list1.recursiveInsert(20);
        list1.printList();
        list1.recursiveDelete(15);
        list1.printList();

        Fibonacci fib = new Fibonacci();
        System.out.println("fibonacci(45): " + fib.fibonacci(45));
        System.out.println("fibonacciTail(45): " + fib.fibonacciTail(45));
    }
}
