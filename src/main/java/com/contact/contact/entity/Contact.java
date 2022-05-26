package com.contact.contact.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Getter
@Setter
@Table(name="contact")
public class Contact {
    @Id
    private Integer id;
    private String email;
    private String contactName;


}