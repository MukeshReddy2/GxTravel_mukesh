package com.galaxe.Service;

import com.galaxe.Entity.EmailDetails;

public interface EmailService {

  void SendingEmail(String Recipient, String MsgBody, String Subject);

  public void SendForSucess(String userEmail, String UserFirstName);

  public void SendForUnSubsribing(String userEmail, String UserFirstName);

  public void SendForOtp(String userEmail, String UserFirstName, double otpSender);

  public void sendPassword(String userEmail, String userPassword);

  String sendMailWithAttachment(EmailDetails details);
}
