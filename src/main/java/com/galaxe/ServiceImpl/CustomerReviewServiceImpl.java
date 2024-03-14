package com.galaxe.ServiceImpl;

import com.galaxe.Dto.CustomerReviewsDto;
import com.galaxe.Entity.CustomerRevies;
import com.galaxe.Entity.User;
import com.galaxe.Exeptions.UserNotFoundExceptions;
import com.galaxe.Mapper.CustomerReviewsMapper;
import com.galaxe.Repository.CustomerReviewReposity;
import com.galaxe.Repository.UserRepository;
import com.galaxe.Service.CustomerReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerReviewServiceImpl implements CustomerReviewService {
  @Autowired private CustomerReviewReposity customerReviewReposity;

  @Autowired private CustomerReviewsMapper customerReviewsMapper;

  @Autowired private UserRepository repository;

  @Override
  public String saveCustomerReview(CustomerReviewsDto customerReviewsDto, String userEmail)
      throws UserNotFoundExceptions {
    User user = repository.findByUserEmail(userEmail);
    CustomerRevies reviews = new CustomerRevies();
    if (user != null) {
      reviews.setUser(user);
      reviews.setRMessage(customerReviewsDto.getRMessage());

      // CustomerRevies customerRevies =
      // customerReviewsMapper.toCustomerReviewEntity(customerReviewsDto);
      customerReviewReposity.save(reviews);
      return "sucess";
    } else {
      throw new UserNotFoundExceptions("User Not found");
    }
  }
}
