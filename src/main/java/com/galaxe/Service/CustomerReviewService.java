package com.galaxe.Service;

import com.galaxe.Dto.CustomerReviewsDto;
import com.galaxe.Exeptions.UserNotFoundExceptions;

public interface CustomerReviewService {
  public String saveCustomerReview(CustomerReviewsDto customerReviewsDto, String userEmail)
      throws UserNotFoundExceptions;
}
