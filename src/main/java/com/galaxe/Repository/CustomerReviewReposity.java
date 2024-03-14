package com.galaxe.Repository;

import com.galaxe.Entity.CustomerRevies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerReviewReposity extends JpaRepository<CustomerRevies, Integer> {}
