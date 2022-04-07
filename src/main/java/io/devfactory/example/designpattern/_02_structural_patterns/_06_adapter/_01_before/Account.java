package io.devfactory.example.designpattern._02_structural_patterns._06_adapter._01_before;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@SuppressWarnings("ClassCanBeRecord")
@RequiredArgsConstructor
@Getter
public class Account {

  private final String name;
  private final String password;
  private final String email;

}
