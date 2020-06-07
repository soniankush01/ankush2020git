package com.excercise.cts.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Users {

  private List<User> items;
}
