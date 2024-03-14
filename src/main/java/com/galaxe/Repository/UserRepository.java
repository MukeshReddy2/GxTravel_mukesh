package com.galaxe.Repository;

import com.galaxe.Entity.User;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, Integer> {

  User findByUserEmail(String userEmail);

  @Query(
      value = "select user_password from gx_travel_user_details where user_email=:userEmail",
      nativeQuery = true)
  String GetUserPasswordByMAil(String userEmail);

  @Query(
      value = "select user_id from gx_travel_user_details where user_email=:userEmail",
      nativeQuery = true)
  Integer GetUserIdByMail(String userEmail);

  @Query(
      value = "select * from gx_travel_user_details where type_status='user';",
      nativeQuery = true)
  public List<User> getAllUsersBasedOnStatus();

  @Query(
      value = "select type_status from gx_travel_user_details where user_email=:userEmail",
      nativeQuery = true)
  public String GetUserStaus(String userEmail);
}
