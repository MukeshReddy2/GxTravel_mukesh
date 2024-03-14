package com.galaxe.Controller;

import com.galaxe.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
  @Autowired EmailService emailService;

  //  @PostMapping("/sendMailWithAttachments")
  //  public String sendMailWithAttachment(@RequestBody EmailDetails details) {
  //    String status = emailService.sendMailWithAttachment(details);
  //
  //    return status;
  //  }

}
