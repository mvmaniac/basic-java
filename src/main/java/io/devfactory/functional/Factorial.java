package io.devfactory.functional;

import java.util.stream.LongStream;

public class Factorial {

    private Factorial() {}

    public static long factorialIterative(long n) {
        long r = 1;

        for (int i = 1; i <= n; i++) {
             r *= i;
        }

        return r;
    }

    public static long factorialRecursive(long n) {
        return n == 1 ? 1 : n * factorialRecursive(n - 1);
    }

    // 일반 재귀와 달리 꼬리 재귀
    // 반환값에서 추가 연산을 필요로 하지 않는다는 점
    // 일반 재귀는 중간결과를 각각의 스택 프레임으로 저장함
    // 꼬리 재귀는 하나의 스택 프레임을 재활용할 가능성이 생김 -> factorialTailRecursive()
    public static long factorialTailRecursive(long n) {
        return factorialHelper(1, n);
    }

    public static long factorialStreams(long n) {
        return LongStream.rangeClosed(1, n).reduce(1, (a, b) -> a * b);
    }

    private static long factorialHelper(long acc, long n) {
        return n == 1 ?  acc : factorialHelper(acc * n, n - 1);
    }

}
