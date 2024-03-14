package com.galaxe.Mapper;

import com.galaxe.Dto.UserDto;
import com.galaxe.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

  public UserDto ToUSerDto(User user) {

    UserDto userDto = new UserDto();
    userDto.setUserFirstName(user.getUserFirstName());
    userDto.setUserLastName(user.getUserLastName());
    userDto.setUserEmail(user.getUserEmail());
    userDto.setUserPassword(user.getUserPassword());
    userDto.setUserDateOfBirth(user.getUserDateOfBirth());
    userDto.setUserSubscribtion(user.getUserSubscribtion());
    userDto.setTypeStatus(user.getTypeStatus());

    return userDto;
  }

  public User ToUserEntity(UserDto userDto) {
    User user2 = new User();
    user2.setUserFirstName(userDto.getUserFirstName());
    user2.setUserLastName(userDto.getUserLastName());
    user2.setUserEmail(userDto.getUserEmail());
    user2.setUserPassword(userDto.getUserPassword());
    user2.setUserDateOfBirth(userDto.getUserDateOfBirth());
    user2.setUserSubscribtion(userDto.getUserSubscribtion());
    user2.setTypeStatus(userDto.getTypeStatus());

    return user2;
  }
}
