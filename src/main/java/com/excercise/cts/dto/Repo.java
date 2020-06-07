package com.excercise.cts.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Repo {
  private List<Item> items;

}
