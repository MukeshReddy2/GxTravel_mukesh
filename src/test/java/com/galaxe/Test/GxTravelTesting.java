package com.galaxe.Test;

import com.galaxe.Exeptions.UserNotFoundExceptions;
import com.galaxe.Service.USerService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GxTravelTesting {

  @Autowired private USerService userService;

  @Test
  public void testUserLoginWithValidInputs() throws Exception {

    String email = "asdfgh@gmail.com";
    String password = "asdf@gmail.com";
    String actualResult = userService.UserLogin(email, password);
    String expectedResult = "Thank You For Login";
    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testUserLoginWithWrongPasswordInputs() throws Exception {
    String email = "asdfgh@gmail.com";
    String password = "asd@gmail.com";
    String actualResult = userService.UserLogin(email, password);
    String expectedResult = "Enter Valid Password";
    Assertions.assertEquals(expectedResult, actualResult);
  }

  @Test
  public void testUserLoginWithInvalidInputs() throws Exception {
    Assertions.assertThrows(
        UserNotFoundExceptions.class,
        () -> {
          String email = "asdfgssssh@gmail.com";
          String password = "asdf@gmail.com";
          userService.UserLogin(email, password);
        });
  }
}
