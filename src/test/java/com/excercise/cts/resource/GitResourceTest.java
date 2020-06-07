package com.excercise.cts.resource;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.excercise.cts.domain.RepositoriesInfo;
import com.excercise.cts.domain.User;
import com.excercise.cts.domain.Users;
import com.excercise.cts.exception.ResponseEntityAdvice;
import com.excercise.cts.service.impl.GitServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class GitResourceTest {

  private MockMvc mockMvc;

  @Mock
  GitServiceImpl gitService;


  @InjectMocks
  ResponseEntityAdvice responseEntityAdvice;

  @InjectMocks
  GitResource gitResource;


  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(gitResource)
            .setControllerAdvice(responseEntityAdvice)
            .build();
  }


  @Test
  public void shouldReturnHTTPOKForGetRepo() throws Exception {
    RepositoriesInfo repositoriesInfo = RepositoriesInfo.builder().build();
    when(gitService.getTopRepo(5)).thenReturn(repositoriesInfo);
    mockMvc.perform(get("/topRepositories").header("Content-Type","application/json").queryParam("numberOfRepo","5"))
            .andExpect(status().isOk());
  }

  @Test
  public void shouldReturnHTTPOKForGetUser() throws Exception {
    Users users = Users.builder().build();
    when(gitService.getUserWithZeroFllower(5)).thenReturn(users);
    mockMvc.perform(get("/zeroFollowers").header("Content-Type","application/json").queryParam("numberOfRepo","5"))
            .andExpect(status().isOk());
  }

}
