package com.galaxe.Dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.sql.Date;
import lombok.Data;

@Data
public class UserEditDto {

  @Pattern(regexp = "^[A-Za-z]+$", message = "Name shuld Contains Only Letters")
  @NotNull(message = "User Name is Required")
  private String userFirstName;

  @Pattern(regexp = "^[A-Za-z]+$", message = "Name shuld Contains Only Letter")
  @NotNull(message = "User LastName is Required")
  private String userLastName;

  @Pattern(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Enter a valid Email")
  @NotNull(message = "User Email is Required")
  private String userEmail;

  @NotNull(message = "Date is Required")
  private Date userDateOfBirth;

  @NotNull(message = "SubscriptionStatus is Required")
  private Boolean userSubscribtion;
}
