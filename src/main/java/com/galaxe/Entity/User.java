package com.galaxe.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.sql.Date;
import java.util.List;
import lombok.Data;

@Entity
@Table(name = "GxTravelUserDetails")
@Data
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer userId;

  private String userFirstName;
  private String userLastName;
  private String userEmail;
  private String userPassword;
  private Date userDateOfBirth;
  private Boolean userSubscribtion;
  private String typeStatus;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<CustomerRevies> customerRevies;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
  private List<FileSaving> fileSavings;
}
