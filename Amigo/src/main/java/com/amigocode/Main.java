package com.amigocode;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Main {

  public static void main(String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @GetMapping("/")
  public greetRes greet() {
    return new greetRes("Hello", List.of("Java", "Golang", "Javascript"), new Person("isuru"));
  }

  record Person(String name) {}

  record greetRes(String greet, List<String> favProgrammingLanguages, Person person) {}

}
