/**
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
 * n<=39
 * <p>
 * 示例1
 * 输入
 * 4
 * 返回值
 * 3
 */

public class Jz07_Fibonacci {
    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }


    public static void main(String[] args) {
        Jz07_Fibonacci fibonacci = new Jz07_Fibonacci();
        System.out.println(fibonacci.fibonacci(16));
    }
}
