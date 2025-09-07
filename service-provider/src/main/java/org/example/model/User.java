package org.example.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
  private Long id;
  private String name;
  private Integer age;
  private Double balance;
}
