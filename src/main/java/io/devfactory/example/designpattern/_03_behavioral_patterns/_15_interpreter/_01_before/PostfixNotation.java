package io.devfactory.example.designpattern._03_behavioral_patterns._15_interpreter._01_before;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

@SuppressWarnings({"ClassCanBeRecord", "squid:S1149"})
@Slf4j
public class PostfixNotation {

  private final String expression;

  public PostfixNotation(String expression) {
    this.expression = expression;
  }

  public void calculate() {
    Stack<Integer> numbers = new Stack<>();

    for (char c : this.expression.toCharArray()) {
      switch (c) {
        case '+' -> numbers.push(numbers.pop() + numbers.pop());
        case '-' -> {
          int right = numbers.pop();
          int left = numbers.pop();
          numbers.push(left - right);
        }
        default -> numbers.push(Integer.parseInt(c + ""));
      }
    }

    log.debug("{}", numbers.pop());
  }

}
