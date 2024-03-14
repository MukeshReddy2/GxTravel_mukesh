package com.galaxe.Exeptions;

public class UserAlredyExisted extends RuntimeException {

  public UserAlredyExisted() {
    super();
    // TODO Auto-generated constructor stub
  }

  public UserAlredyExisted(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
    // TODO Auto-generated constructor stub
  }

  public UserAlredyExisted(String message, Throwable cause) {
    super(message, cause);
    // TODO Auto-generated constructor stub
  }

  public UserAlredyExisted(String message) {
    super(message);
    // TODO Auto-generated constructor stub
  }

  public UserAlredyExisted(Throwable cause) {
    super(cause);
    // TODO Auto-generated constructor stub
  }
}
