package com.galaxe.ServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

import com.galaxe.Dto.UserDto;
import com.galaxe.Exeptions.UserAlredyExisted;
import com.galaxe.Exeptions.UserNotFoundExceptions;
import com.galaxe.Service.USerService;
import java.sql.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceImplTest {

  @Autowired private USerService uSerService;
  //
  //  @Mock UserMapper userMapper;
  //
  //  @Mock EmailService emailService;
  //
  //  @InjectMocks UserServiceImpl userServiceImpl;

  @Test
  public void testSubscriptionStatusTrue() throws UserNotFoundExceptions {

    String userEmail = "vajralamukeshreddy@gmail.com";
    Boolean userSubscribtionTrue = true;

    assertEquals(
        "Sucessfully Subscribed", uSerService.UpdateSubscription(userEmail, userSubscribtionTrue));
  }

  @Test
  public void testSubscriptionStatusFalse() throws UserNotFoundExceptions {

    String userEmail = "vajralamukeshreddy@gmail.com";

    Boolean userSubscribtionFalse = false;

    assertEquals(
        "Sucessfully UnSubscribed",
        uSerService.UpdateSubscription(userEmail, userSubscribtionFalse));
  }

  @Test
  public void testSaveUserOnSucess() throws Exception {
    UserDto user = new UserDto();
    user.setUserFirstName("Mukesh");
    user.setUserLastName("Reddyt");
    user.setUserEmail("asdfaaaaa@gmail.com");
    user.setUserPassword("Mukesh@1234");
    user.setUserSubscribtion(true);
    user.setUserDateOfBirth(new Date(2001, 07, 25));
    String actualMsg = uSerService.SaveUser(user);
    String expectedMsg = "Thank You for Subscribing";
    assertEquals(actualMsg, expectedMsg);
  }

  @Test
  public void testSaveUserOnUnSucess() throws Exception {
    UserDto user = new UserDto();
    user.setUserFirstName("000");
    user.setUserLastName("Reddyt");
    user.setUserEmail("asdfaaaua@gmail.com");
    user.setUserPassword("Mukesh@1234");
    user.setUserSubscribtion(true);
    user.setUserDateOfBirth(new Date(2001, 07, 25));
    //    String actualMsg = uSerService.SaveUser(user);
    Assertions.assertThrows(UserAlredyExisted.class, () -> uSerService.SaveUser(user));
  }
}
