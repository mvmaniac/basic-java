package io.devfactory.designpattern.generation.builder.service;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Computer {

  private String cpu;
  private Memory[] ram;
  private Storage[] storage;

  public Computer() {
    log.debug("Computer 객체가 생성이 되었습니다.");
  }

  public void assembleCpu(String cpu) {
    this.cpu = cpu;
  }

  public int sizeOfMemory() {
    return Arrays.stream(ram)
        .mapToInt(Memory::getSize)
        .sum()
        ;
  }

  public void assembleMemory(Memory[] memories) {
    this.ram = memories;
  }

  public int sizeOfStorage() {
    return Arrays.stream(storage)
        .mapToInt(Storage::getSize)
        .sum()
        ;
  }

  public void assembleStorage(Storage[] storage) {
    this.storage = storage;
  }

  @Override
  public String toString() {
    return String.format("이 컴퓨터의 사양은 CPU = %s, RAM = %dGB, Storage = %dGB 입니다.",
        cpu, sizeOfMemory(), sizeOfStorage());
  }

}
