package Recursion;

/**
 * Created by shinsy1023 on 2016. 11. 7..
 */
public class Fibonacci {
    public int fibonacci(int number) {
        if (number == 1 || number == 2)
            return 1;
        else
            return fibonacci(number - 1) + fibonacci(number - 2);
    }

    public int fibonacciTail(int number) {
        return fibonacciTail(1, 1, number);
    }

    public int fibonacciTail(int number, int result, int check){
        if (check == 2)
            return result;
        else
            return fibonacciTail(result, number + result, check - 1);
    }
}

