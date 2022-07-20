package com.example.demo.user;

import java.time.LocalDateTime;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="user_tbl")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String username;

  private String displayName;

  private String email;

  private String password;

  private String role;

  private LocalDateTime lastUpdated;
  
}
