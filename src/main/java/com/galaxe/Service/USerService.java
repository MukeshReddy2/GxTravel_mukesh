package com.galaxe.Service;

import com.galaxe.Dto.UserDto;
import com.galaxe.Dto.UserEditDto;
import com.galaxe.Exeptions.UserNotFoundExceptions;
import java.util.List;

public interface USerService {

  public String SaveUser(UserDto userDto) throws Exception;

  public String UserLogin(String userEmail, String userPassword) throws Exception;

  public void DeleteUserBymail(String userEmail) throws UserNotFoundExceptions;

  public String UpdateSubscription(String userEmail, Boolean userSubscribtion)
      throws UserNotFoundExceptions;

  public Boolean SubscriptionStatus(String userEmail) throws UserNotFoundExceptions;

  public Boolean ChangingSubscribtionStatusToTrue(String userEmail, String userPassword)
      throws UserNotFoundExceptions;

  public Boolean ForgottenPassword(String userEmail) throws UserNotFoundExceptions;

  public List<UserDto> GetAllUsersByStatus();

  public String getUserStatus(String userEmail) throws UserNotFoundExceptions;

  public String updateUser(UserEditDto userEditDto) throws UserNotFoundExceptions;
}
