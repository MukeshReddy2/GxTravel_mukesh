package com.galaxe.Controller;

import com.galaxe.Dto.UserDto;
import com.galaxe.Dto.UserEditDto;
import com.galaxe.Exeptions.UserNotFoundExceptions;
import com.galaxe.Service.USerService;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin("*")
public class UserController {

  @Autowired USerService uSerService;

  @PostMapping("/SaveUser")
  public ResponseEntity<String> SaveUser(@Valid @RequestBody UserDto userDto) throws Exception {
    return new ResponseEntity<String>(uSerService.SaveUser(userDto), HttpStatus.OK);
  }

  @PostMapping("/LoginChecking/{userEmail}/{userPassword}")
  public ResponseEntity<String> LoginChecking(
      @PathVariable String userEmail, @PathVariable String userPassword) throws Exception {
    return new ResponseEntity<String>(
        uSerService.UserLogin(userEmail, userPassword), HttpStatus.OK);
  }

  @DeleteMapping("/deleteAccount/{userEmail}")
  public ResponseEntity<String> deleteAccount(@PathVariable String userEmail)
      throws UserNotFoundExceptions {
    uSerService.DeleteUserBymail(userEmail);
    return new ResponseEntity<String>("Deleting your accounr", HttpStatus.OK);
  }

  @PutMapping("/UpdateSubscription/{userEmail}/{userSubscribtion}")
  public ResponseEntity<String> UpdateSubscription(
      @PathVariable String userEmail, @PathVariable Boolean userSubscribtion)
      throws UserNotFoundExceptions {
    return new ResponseEntity<String>(
        uSerService.UpdateSubscription(userEmail, userSubscribtion), HttpStatus.OK);
  }

  @GetMapping("/SubscriptionStatus/{userEmail}")
  public ResponseEntity<Boolean> SubscriptionStatus(@PathVariable String userEmail)
      throws UserNotFoundExceptions {
    return new ResponseEntity<Boolean>(uSerService.SubscriptionStatus(userEmail), HttpStatus.OK);
  }

  @PutMapping("/ChangingSubscribtionStatusToTrue/{userEmail}/{userPassword}")
  public ResponseEntity<Boolean> ChangingSubscribtionStatusToTrue(
      @PathVariable String userEmail, @PathVariable String userPassword)
      throws UserNotFoundExceptions {
    return new ResponseEntity<Boolean>(
        uSerService.ChangingSubscribtionStatusToTrue(userEmail, userPassword), HttpStatus.OK);
  }

  @PostMapping("/ForgottenPassword/{userEmail}")
  public ResponseEntity<Boolean> ForgottenPassword(@PathVariable String userEmail)
      throws UserNotFoundExceptions {
    return new ResponseEntity<Boolean>(uSerService.ForgottenPassword(userEmail), HttpStatus.OK);
  }

  @GetMapping("/GetAllUsersByStatus")
  public ResponseEntity<List<UserDto>> GetAllUsersByStatus() {
    return new ResponseEntity<List<UserDto>>(uSerService.GetAllUsersByStatus(), HttpStatus.OK);
  }

  @GetMapping("/getUserStatus/{userEmail}")
  public ResponseEntity<String> getUserStatus(@PathVariable String userEmail)
      throws UserNotFoundExceptions {
    return new ResponseEntity<String>(uSerService.getUserStatus(userEmail), HttpStatus.OK);
  }

  @PutMapping("/updateUser")
  public ResponseEntity<String> updateUser(@Valid @RequestBody UserEditDto userEditDto)
      throws UserNotFoundExceptions {
    return new ResponseEntity<String>(uSerService.updateUser(userEditDto), HttpStatus.OK);
  }
}
