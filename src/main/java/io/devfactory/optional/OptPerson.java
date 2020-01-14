package io.devfactory.optional;

import java.util.Optional;

public class OptPerson {

    // 필드 형식으로 Optional 를 지정하는 것은 권장하지 않음 (ex. Optional<OptCar>)
    // 일단 직렬화를 지원하지 않음, 자세한건 모던 자바 인 액션 p.377 확인
    private OptCar car;

    public OptPerson(OptCar car) {
        this.car = car;
    }

    public Optional<OptCar> getCarAsOptional() {
        return Optional.ofNullable(car);
    }

}
