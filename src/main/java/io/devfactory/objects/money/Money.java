package io.devfactory.objects.money;

import java.math.BigDecimal;
import java.util.Objects;

// 금액을 Long 타입이 아니라 하나의 도메인으로 구현
// Long 타입이 변수의 크기나 연산자의 종류와 관련된 구현 관점의 제약은 표현 할 수 있으나,
// Money 타입 처럼 저장하는 값이 금액과 관련돼 있다는 의미를 전달 할 수 없고,
// 금액과 관련된 로직이 서로 다른 곳에 중복되어 구현되는 것을 막을 수 없음.
// 따라서 의미를 좀 더 명시적이고 분명하게 표현할 수 있다면 객체를 사용해서 해당 개념을 구현 하라.
public class Money {

    public static final Money ZERO = Money.wons(0);

    private final BigDecimal amount;

    public static Money wons(long amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    public static Money wons(double amount) {
        return new Money(BigDecimal.valueOf(amount));
    }

    private Money(BigDecimal amount) {
        this.amount = amount;
    }

    public Money plus(Money money) {
        return new Money(this.amount.add(money.amount));
    }

    public Money minus(Money money) {
        return new Money(this.amount.subtract(money.amount));
    }

    public Money times(double percent) {
        return new Money(this.amount.multiply(BigDecimal.valueOf(percent)));
    }

    public boolean isLessThan(Money other) {
        return amount.compareTo(other.amount) < 0;
    }

    public boolean isGreaterThanEqual(Money other) {
        return amount.compareTo(other.amount) >= 0;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Money)) {
            return false;
        }

        Money other = (Money) object;
        return Objects.equals(amount.doubleValue(), other.amount.doubleValue());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(amount);
    }

    @Override
    public String toString() {
        return amount.toString() +"원";
    }

}
