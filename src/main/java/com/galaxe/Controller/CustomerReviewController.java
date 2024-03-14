package com.galaxe.Controller;

import com.galaxe.Dto.CustomerReviewsDto;
import com.galaxe.Exeptions.UserNotFoundExceptions;
import com.galaxe.Service.CustomerReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@CrossOrigin("*")
public class CustomerReviewController {

  @Autowired CustomerReviewService customerReviewService;

  @PostMapping("/saveCustomreReviews/{userEmail}")
  public ResponseEntity<String> saveCustomreReviews(
      @RequestBody CustomerReviewsDto customerReviewsDto, @PathVariable String userEmail)
      throws UserNotFoundExceptions {
    System.out.println("jbdb:" + customerReviewsDto);
    return new ResponseEntity<String>(
        customerReviewService.saveCustomerReview(customerReviewsDto, userEmail), HttpStatus.OK);
  }
}
