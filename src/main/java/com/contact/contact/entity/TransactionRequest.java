package com.contact.contact.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionRequest {

    private Contact contact;
    private int id;
   // private String name;
    private String phone;
    private String address;



}