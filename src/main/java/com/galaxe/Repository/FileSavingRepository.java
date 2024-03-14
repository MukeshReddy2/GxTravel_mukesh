package com.galaxe.Repository;

import com.galaxe.Entity.FileSaving;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileSavingRepository extends JpaRepository<FileSaving, Integer> {}
