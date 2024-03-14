package com.galaxe.ServiceImpl;

import com.galaxe.Dto.UserDto;
import com.galaxe.Dto.UserEditDto;
import com.galaxe.Entity.User;
import com.galaxe.Exeptions.UserAlredyExisted;
import com.galaxe.Exeptions.UserNotFoundExceptions;
import com.galaxe.Mapper.UserMapper;
import com.galaxe.Repository.UserRepository;
import com.galaxe.Service.EmailService;
import com.galaxe.Service.USerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements USerService {
  @Autowired UserMapper userMapper;

  @Autowired UserRepository userRepository;
  @Autowired EmailService emailService;

  @Override
  public String SaveUser(UserDto userDto) throws Exception {

    User user = userRepository.findByUserEmail(userDto.getUserEmail());

    if (user == null) {
      if (userDto.getUserPassword().equals("Siva@1234")) {
        userDto.setTypeStatus("admin");
      } else {
        userDto.setTypeStatus("user");
      }
      userMapper.ToUSerDto(userRepository.save(userMapper.ToUserEntity(userDto)));
      emailService.SendForSucess(userDto.getUserEmail(), userDto.getUserFirstName());
      return "Thank You for Subscribing";
    }

    throw new UserAlredyExisted("Given mail was Registred before try with another mail");
  }

  @Override
  public String UserLogin(String userEmail, String userPassword) throws Exception {
    User userRep = userRepository.findByUserEmail(userEmail);

    if (userRep != null) {

      if (userPassword.equals(userRep.getUserPassword())) {
        return "Thank You For Login";
      } else {
        return "Enter Valid Password";
      }

    } else {
      throw new UserNotFoundExceptions("Enter Valid Email!!");
    }
  }

  @Override
  public void DeleteUserBymail(String userEmail) throws UserNotFoundExceptions {
    User user = userRepository.findByUserEmail(userEmail);
    if (user != null) {
      Integer userID = userRepository.GetUserIdByMail(userEmail);
      System.out.println(userRepository.GetUserIdByMail(userEmail));
      userRepository.deleteById(userID);
      //			emailService.SendForDeletingAccount(userEmail);

    } else {
      throw new UserNotFoundExceptions("user is not present");
    }
  }

  @Override
  public String UpdateSubscription(String userEmail, Boolean userSubscribtion)
      throws UserNotFoundExceptions {
    User user = userRepository.findByUserEmail(userEmail);
    if (user != null) {

      user.setUserSubscribtion(userSubscribtion);
      userRepository.save(user);
      if (userSubscribtion.equals(true)) {
        emailService.SendForSucess(userEmail, user.getUserFirstName());
        //        user.getUserFirstName()

        return "Sucessfully Subscribed";
      } else {
        emailService.SendForUnSubsribing(userEmail, user.getUserFirstName());
        return "Sucessfully UnSubscribed";
      }

    } else {
      throw new UserNotFoundExceptions("USer Not Present");
    }
  }

  @Override
  public Boolean SubscriptionStatus(String userEmail) throws UserNotFoundExceptions {
    User user = userRepository.findByUserEmail(userEmail);
    if (userEmail.isBlank()) {
      throw new UserNotFoundExceptions("please login");
    }
    if (user != null) {
      return user.getUserSubscribtion();
    } else {
      throw new UserNotFoundExceptions("Please login");
    }
  }

  @Override
  public Boolean ChangingSubscribtionStatusToTrue(String userEmail, String userPassword)
      throws UserNotFoundExceptions {
    User user = userRepository.findByUserEmail(userEmail);

    if (user != null) {

      if (user.getUserPassword().equals(userPassword)) {

        user.setUserSubscribtion(true);
        userRepository.save(user);

        emailService.SendForSucess(user.getUserEmail(), user.getUserFirstName());
        double message = Math.random();
        System.out.println(message);

        return true;
      } else {
        return false;
      }
    } else {
      throw new UserNotFoundExceptions("user not found with this email");
    }
  }

  @Override
  public Boolean ForgottenPassword(String userEmail) throws UserNotFoundExceptions {
    User user = userRepository.findByUserEmail(userEmail);
    if (user != null) {

      emailService.sendPassword(user.getUserEmail(), user.getUserPassword());
      return true;

    } else {
      throw new UserNotFoundExceptions("Enter a valid Email");
    }
  }

  @Override
  public List<UserDto> GetAllUsersByStatus() {
    List<User> users = userRepository.getAllUsersBasedOnStatus();
    List<UserDto> userDtos = new ArrayList<>();
    for (User user : users) {
      user.setUserPassword(null);
      userDtos.add(userMapper.ToUSerDto(user));
    }
    return userDtos;
  }

  @Override
  public String getUserStatus(String userEmail) throws UserNotFoundExceptions {
    User user = userRepository.findByUserEmail(userEmail);
    if (user != null) {
      String status = userRepository.GetUserStaus(user.getUserEmail());
      System.out.println(status);
      return status;
    } else {
      throw new UserNotFoundExceptions("User Not Present");
    }
  }

  @Override
  public String updateUser(UserEditDto userEditDto) throws UserNotFoundExceptions {
    User user = userRepository.findByUserEmail(userEditDto.getUserEmail());
    User usersave = new User();
    if (user != null) {
      user.setUserFirstName(userEditDto.getUserFirstName());
      user.setUserLastName(userEditDto.getUserLastName());
      user.setUserDateOfBirth(userEditDto.getUserDateOfBirth());
      user.setUserSubscribtion(userEditDto.getUserSubscribtion());
      userRepository.save(user);

      return "sucess";
    } else {
      throw new UserNotFoundExceptions("Email not exists");
    }
  }
}
