package com.excercise.cts.domain;

import lombok.Builder;
import lombok.Data;

import java.util.List;


@Data
@Builder
public class RepositoriesInfo {

  private List<RepositoryInfo> repositoriesInfoList;
}
