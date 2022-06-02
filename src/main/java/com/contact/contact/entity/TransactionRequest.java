package com.contact.contact.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

   private Contact contact;
    private Integer id;
    private String phone;
    private String address;

   // private User user;



}