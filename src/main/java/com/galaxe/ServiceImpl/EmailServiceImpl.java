package com.galaxe.ServiceImpl;

import com.galaxe.Entity.EmailDetails;
import com.galaxe.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

  @Autowired JavaMailSender javaMailSender;

  @Value("${spring.mail.username}")
  private String sender;

  @Override
  public void SendingEmail(String Recipient, String MsgBody, String Subject) {

    // Creating a simple mail message
    SimpleMailMessage mailMessage = new SimpleMailMessage();

    // Setting up necessary details
    mailMessage.setFrom(sender);
    mailMessage.setTo(Recipient);
    mailMessage.setText(MsgBody);
    mailMessage.setSubject(Subject);
    javaMailSender.send(mailMessage);
  }

  @Override
  public void SendForSucess(String userEmail, String UserFirstName) {
    String Subject = "Thank you for regestring ";
    String MsgBody =
        "Dear"
            + " "
            + UserFirstName
            + ","
            + "\n\n"
            + " Thank you for subscribing our platform you will get every update"
            + "\n\n"
            + "Thanks & Regards,\r\n"
            + "GxTravel";
    SendingEmail(userEmail, MsgBody, Subject);
  }

  public void SendForUnSubsribing(String userEmail, String UserFirstName) {

    String Subject = "un subscribed";
    String MsgBody = "You have un subscribed to enjoy over services resubscribe again";
    SendingEmail(userEmail, MsgBody, Subject);
  }

  //  public void SendForVerification(String userEmail, String UserFirstName, double otp) {}

  @Override
  public void SendForOtp(String userEmail, String UserFirstName, double otpSender) {
    String Subject = "One time otp";
    String MsgBody = "Verification Code : " + otpSender;
    SendingEmail(userEmail, MsgBody, Subject);
  }

  @Override
  public void sendPassword(String userEmail, String userPassword) {
    String Subject = "Recovering Password";
    String MsgBody = "Password : " + userPassword;
    SendingEmail(userEmail, MsgBody, Subject);
  }
  //
  //  @Override
  //  public String sendMailWithAttachment(EmailDetails details) {
  //
  //    // Creating a mime message
  //    MimeMessage mimeMessage = javaMailSender.createMimeMessage();
  //    MimeMessageHelper mimeMessageHelper;
  //
  //    try {
  //
  //      // Setting multipart as true for attachments to
  //      // be send
  //      mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
  //      mimeMessageHelper.setFrom(sender);
  //      mimeMessageHelper.setTo(details.getRecipient());
  //      mimeMessageHelper.setText(details.getMsgBody());
  //      mimeMessageHelper.setSubject(details.getSubject());
  //
  //      // Adding the attachment
  //      //      FileSystemResource file = new FileSystemResource(new
  // File(details.getAttachment()));
  //
  //      mimeMessageHelper.addAttachment(file.getFilename(), file);
  //
  //      // Sending the mail
  //      javaMailSender.send(mimeMessage);
  //      return "Mail sent Successfully";
  //    }
  //
  //    // Catch block to handle MessagingException
  //    catch (MessagingException e) {
  //
  //      // Display message when exception occurred
  //      return "Error while sending mail!!!";
  //    }
  //  }

  @Override
  public String sendMailWithAttachment(EmailDetails details) {
    // TODO Auto-generated method stub
    return null;
  }
}
