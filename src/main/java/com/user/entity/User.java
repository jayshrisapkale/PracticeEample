package com.user.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user_service")
public class User {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    private String name;
    private String phone;
    private String address;
}
