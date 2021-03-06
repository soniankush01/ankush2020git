package com.excercise.cts.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

  private String id;
  private String login;
  private String html_url;
  @JsonIgnore
  private Owner owner;
}
