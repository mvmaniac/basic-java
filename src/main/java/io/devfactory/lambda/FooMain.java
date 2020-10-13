package io.devfactory.lambda;

import java.util.function.IntConsumer;

public class FooMain {

    public static void main(String[] args) {
        final FooMain foo = new FooMain();
        foo.run();
    }

    private void run() {
        int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                // int baseNumber = 11; // 다시 정의가 됨
                System.out.println(baseNumber);
            }
        }

        // 익명 클래스
        IntConsumer intConsumer = new IntConsumer() {
            @Override
            public void accept(int baseNumber) { // 다시 정의가 됨
                System.out.println(baseNumber);
            }
        };

        // 람다
        // 로컬 클래스와 익명 클래스와의 차이는 람다는 쉐도잉이 안됨
        // 로컬 클래스의 경우에는 지역변수를 baseNumber 로 해서 재정의가 됨
        // 익명 클래스도 마찬가지로 파라미터 명을 baseNumber 로 해서 재정의가 됨
        // 람다의 경우에는 람다 안에서 baseNumber 를 다시 재정의 할 수 없음, 한 마디로 같은 scope 임
        // 또한 baseNumber 를 아래 람다 이후에 변경을 한다면 람다에서 참조 할 수 없음 (effective final...)
        IntConsumer printInt = i -> System.out.println(i + baseNumber);
    }

}
