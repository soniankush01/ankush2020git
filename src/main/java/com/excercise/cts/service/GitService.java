package com.excercise.cts.service;

import com.excercise.cts.domain.RepositoriesInfo;
import com.excercise.cts.domain.Users;
import com.excercise.cts.exception.CTSBusinessException;

public interface GitService {

   RepositoriesInfo getTopRepo (int numberOfRepo) throws CTSBusinessException;

   Users getUserWithZeroFllower(int numberOfRepo) throws CTSBusinessException;
}
