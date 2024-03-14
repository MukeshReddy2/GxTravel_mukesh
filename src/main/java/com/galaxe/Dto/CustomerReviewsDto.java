package com.galaxe.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.galaxe.Entity.User;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CustomerReviewsDto {

  @NotNull(message = "Message required")
  @JsonProperty("rMessage")
  private String rMessage;

  private User user;
}
