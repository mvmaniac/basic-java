package io.devfactory.designpattern.generation.builder;

import io.devfactory.designpattern.generation.builder.service.Computer;
import io.devfactory.designpattern.generation.builder.service.Memory;
import io.devfactory.designpattern.generation.builder.service.Storage;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

// 알고리즘의 하위 클래스를 구현
@SuppressWarnings("squid:S3864")
@Slf4j
public class ProductModel extends Algorithm {

  public ProductModel() {
    log.debug("Algorithm ProductModel 객체를 생성하였습니다.");
    this.computer = new Computer();
  }

  @Override
  public void assembleCpu(String cpu) {
    log.debug("CPU 를 설정합니다.");

    this.computer.assembleCpu(cpu);
  }

  @Override
  public void assembleMemory(int[] memory) {
    log.debug("RAM 를 설정합니다.");

    final List<Memory> memoryList = Arrays.stream(memory)
        .peek(mem -> log.debug("슬롯 {}GB 장착", mem))
        .mapToObj(Memory::new)
        .collect(toList());

    Memory[] memories = new Memory[memoryList.size()];
    this.computer.assembleMemory(memoryList.toArray(memories));
  }

  @Override
  public void assembleStorage(int[] storage) {
    log.debug("Storage 를 설정합니다.");

    final List<Storage> storageList = Arrays.stream(storage)
        .peek(st -> log.debug("슬롯 {}GB 장착", st))
        .mapToObj(Storage::new)
        .collect(toList());

    Storage[] storages = new Storage[storageList.size()];
    this.computer.assembleStorage(storageList.toArray(storages));
  }

}
