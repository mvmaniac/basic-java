package io.devfactory.example.modernjava.reactive.rxjava;

import io.devfactory.example.modernjava.reactive.TempInfo;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TempObserver implements Observer<TempInfo> {

  @Override
  public void onSubscribe(Disposable d) {
    // nothing
  }

  @Override
  public void onNext(TempInfo tempInfo) {
    log.debug("[dev] TempObserver temp: {}", tempInfo);
  }

  @Override
  public void onError(Throwable e) {
    log.error(e.getMessage());
  }

  @Override
  public void onComplete() {
    log.debug("[dev] TempObserver Done!");
  }

}
