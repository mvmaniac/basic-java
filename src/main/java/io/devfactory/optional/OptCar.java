package io.devfactory.optional;

import java.util.Optional;

public class OptCar {

    // 필드 형식으로 Optional 지정하는 것은 권장하지 않음
    // 일단 직렬화를 지원하지 않음, 자세한건 모던 자바 인 액션 p.377 확인
    // private Optional<OptInsurance> insurance;

    private OptInsurance insurance;

    public OptCar(OptInsurance insurance) {
        this.insurance = insurance;
    }

    public Optional<OptInsurance> getInsuranceAsOptional() {
        return Optional.ofNullable(insurance);
    }

}
