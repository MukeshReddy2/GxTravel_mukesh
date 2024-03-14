package com.galaxe.Mapper;

import com.galaxe.Dto.CustomerReviewsDto;
import com.galaxe.Entity.CustomerRevies;
import org.springframework.stereotype.Component;

@Component
public class CustomerReviewsMapper {

  public CustomerRevies toCustomerReviewEntity(CustomerReviewsDto customerReviewsDto) {
    CustomerRevies customerRevies = new CustomerRevies();
    customerRevies.setUser(customerReviewsDto.getUser());
    customerRevies.setRMessage(customerReviewsDto.getRMessage());
    return customerRevies;
  }

  public CustomerReviewsDto toCustomerReviewDto(CustomerRevies customerRevies) {
    CustomerReviewsDto customerReviewsDto = new CustomerReviewsDto();
    customerReviewsDto.setUser(customerRevies.getUser());
    customerReviewsDto.setRMessage(customerRevies.getRMessage());

    return customerReviewsDto;
  }
}
