package com.retro.service.retrofitMicro.dto;

import lombok.*;

import javax.persistence.Table;
import java.util.Date;


@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Employee
{
    private int id;
    private String name;
    private int age;
}