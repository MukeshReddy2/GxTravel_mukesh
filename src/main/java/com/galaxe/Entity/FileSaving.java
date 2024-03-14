package com.galaxe.Entity;

import jakarta.persistence.Column;
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
@Table(name = "FileSavingSample")
public class FileSaving {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Integer fileId;

  @Column(columnDefinition = "VARBINARY(MAX)")
  private byte[] fileData;

  @ManyToOne
  @JoinColumn(name = "userId")
  private User user;

  private Integer adminId;
  private String travelMode;
}
