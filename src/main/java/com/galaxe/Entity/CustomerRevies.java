package com.galaxe.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "GxTravelReviewDetails")
public class CustomerRevies {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer rId;

  @JsonProperty("rMessage")
  private String rMessage;

  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;
}
